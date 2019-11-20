package com.hxy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxy.mapper.EdocCategoryMapper;
import com.hxy.pojo.EdocCategory;
import com.hxy.pojo.EdocEntry;
import com.hxy.pojo.EdocEntryExample;
import com.hxy.service.EdocCategoryService;
import com.hxy.service.EdocEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hxy.pojo.EdocEntryExample.Criteria;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InitController {
    @Autowired
    EdocEntryService es;
    @Autowired
    EdocCategoryService cs;
    @RequestMapping("/inits")
    public String inits(HttpSession session) {
        PageHelper.startPage(1, 2);

        List<EdocEntry> elist = es.getall(null);
        PageInfo<EdocEntry> info = new PageInfo<EdocEntry>(elist);
        boolean isLastPage=false;
        if(isLastPage==true){
            info.setNextPage(info.getPages());
        }
        if(info.getPageNum()>=info.getPages()){
            info.setPageNum(info.getPages());
        }

        List<EdocCategory> clist = cs.selectByExample(null);

        session.setAttribute("clist", clist);
        session.setAttribute("list", info.getList());
        session.setAttribute("info", info);
        return "index";
    }
    @RequestMapping("in/{index}")
    private String in(HttpSession session, @PathVariable("index") Integer index) {
        Integer lname = (Integer) session.getAttribute("lname");
        PageHelper.startPage(index, 2);
        if (lname != null) {
            EdocEntryExample ee = new EdocEntryExample();
            Criteria c = ee.createCriteria();
            c.andCategoryidEqualTo(lname);
            List<EdocEntry> e = es.getall(ee);
            PageInfo<EdocEntry> info = new PageInfo<EdocEntry>(e);
            boolean isLastPage = false;
            if (isLastPage == true) {
                info.setNextPage(info.getPages());
            }
            session.setAttribute("list", info.getList());
            session.setAttribute("info", info);
        } else {
            List<EdocEntry> e = es.getall(null);
            PageInfo<EdocEntry> info = new PageInfo<EdocEntry>(e);
            boolean isLastPage = false;
            if (isLastPage == true) {
                info.setNextPage(info.getPages());
            }
            session.setAttribute("list", info.getList());
            session.setAttribute("info", info);

        }
        return "index";
    }
    @RequestMapping("n")
    private String n(HttpSession session, Integer lname) {
        PageHelper.startPage(1, 2);
        if (lname == 0) {
            session.removeAttribute("lname");
            return "init";
        }
        EdocEntryExample ee = new EdocEntryExample();
        Criteria c = ee.createCriteria();
        c.andCategoryidEqualTo(lname);
        List<EdocEntry> e = es.getall(ee);
        PageInfo<EdocEntry> info = new PageInfo<EdocEntry>(e);
        boolean isLastPage = false;
        if (isLastPage== true) {
            info.setNextPage(info.getPages());
        }
        session.setAttribute("lname", lname);
        session.setAttribute("list", info.getList());
        session.setAttribute("info", info);
        return "index";
    }


    @RequestMapping("/k")
    public String k(EdocEntry doc) {
        EdocEntry en=new EdocEntry();
        en.setTitle(doc.getTitle());
        en.setCategoryid(doc.getCategoryid());
        en.setId(doc.getId());
        en.setSummary(doc.getSummary());
        en.setUploaduser(doc.getUploaduser());
        en.setCreatedate(doc.getCreatedate());
        int n=es.insert(doc);
        if(n>0){
            return "init";
        }
        return "add";
    }
    @RequestMapping("/up/{id}")
    public String up(@PathVariable("id") Integer id, HttpSession session) {
        List<EdocCategory> clist = cs.selectByExample(null);
        session.setAttribute("clist", clist);
        EdocEntry d = es.selectByPrimaryKey(id);
        session.setAttribute("d", d);
        return "update";
    }

    @RequestMapping("/upp")
    public String upp(EdocEntry e, HttpSession session) {
        EdocEntry ce = (EdocEntry) session.getAttribute("d");
        e.setId(ce.getId());
        int n = es.updateByPrimaryKey(e);
        if (n > 0) {
            return "init";
        } else {
            return "update";
        }
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id, HttpSession session) {
        int c = es.deleteByPrimaryKey(id);
        if(c>0){
            session.setAttribute("shan", "删除成功");
        }else{
            session.setAttribute("shan", "删除失败");
        }
        return "init";

    }
}
