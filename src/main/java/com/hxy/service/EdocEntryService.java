package com.hxy.service;

import com.hxy.pojo.EdocEntry;
import com.hxy.pojo.EdocEntryExample;

import java.util.List;

public interface EdocEntryService {
    List<EdocEntry> getall(EdocEntryExample example);
    int insert(EdocEntry record);
    EdocEntry selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(EdocEntry record);
    int  deleteByPrimaryKey(Integer id);
}
