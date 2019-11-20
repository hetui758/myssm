package com.hxy.mapper;

import com.hxy.pojo.EdocCategory;
import com.hxy.pojo.EdocCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EdocCategoryMapper {
    int countByExample(EdocCategoryExample example);

    int deleteByExample(EdocCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EdocCategory record);

    int insertSelective(EdocCategory record);

    List<EdocCategory> selectByExample(EdocCategoryExample example);

    EdocCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EdocCategory record, @Param("example") EdocCategoryExample example);

    int updateByExample(@Param("record") EdocCategory record, @Param("example") EdocCategoryExample example);

    int updateByPrimaryKeySelective(EdocCategory record);

    int updateByPrimaryKey(EdocCategory record);
}