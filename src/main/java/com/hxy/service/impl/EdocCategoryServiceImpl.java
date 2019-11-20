package com.hxy.service.impl;

import com.hxy.mapper.EdocCategoryMapper;
import com.hxy.pojo.EdocCategory;
import com.hxy.pojo.EdocCategoryExample;
import com.hxy.service.EdocCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EdocCategoryServiceImpl implements EdocCategoryService {
    @Autowired
    EdocCategoryMapper cm;

    @Override
    public List<EdocCategory> gatall() {
        return cm.selectByExample(null);
    }

    @Override
    public EdocCategory getbyid(Integer id) {
        return cm.selectByPrimaryKey(id);
    }

    @Override
    public List<EdocCategory> selectByExample(EdocCategoryExample example) {
        return cm.selectByExample(example);
    }
}
