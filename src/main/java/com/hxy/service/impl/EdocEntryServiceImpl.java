package com.hxy.service.impl;

import com.hxy.mapper.EdocEntryMapper;
import com.hxy.pojo.EdocEntry;
import com.hxy.pojo.EdocEntryExample;
import com.hxy.service.EdocEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EdocEntryServiceImpl implements EdocEntryService {
    @Autowired
    EdocEntryMapper em;
    @Override
    public List<EdocEntry> getall(EdocEntryExample example) {
        return em.selectByExample(example);
    }

    @Override
    public int insert(EdocEntry record) {
        return em.insert(record);
    }

    @Override
    public EdocEntry selectByPrimaryKey(Integer id) {
        return em.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(EdocEntry record) {
        return em.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return em.deleteByPrimaryKey(id);
    }
}
