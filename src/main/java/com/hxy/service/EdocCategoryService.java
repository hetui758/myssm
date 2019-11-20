package com.hxy.service;

import com.hxy.pojo.EdocCategory;
import com.hxy.pojo.EdocCategoryExample;

import java.util.List;

public interface EdocCategoryService {
    List<EdocCategory> gatall();
    EdocCategory getbyid(Integer id);
    List<EdocCategory> selectByExample(EdocCategoryExample example);
}
