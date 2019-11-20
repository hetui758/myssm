package com.hxy.mapper;

import com.hxy.pojo.EdocEntry;
import com.hxy.pojo.EdocEntryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EdocEntryMapper {
    int countByExample(EdocEntryExample example);

    int deleteByExample(EdocEntryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EdocEntry record);

    int insertSelective(EdocEntry record);

    List<EdocEntry> selectByExample(EdocEntryExample example);

    EdocEntry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EdocEntry record, @Param("example") EdocEntryExample example);

    int updateByExample(@Param("record") EdocEntry record, @Param("example") EdocEntryExample example);

    int updateByPrimaryKeySelective(EdocEntry record);

    int updateByPrimaryKey(EdocEntry record);
    

    List<EdocEntry> getall(EdocEntryExample example);

}