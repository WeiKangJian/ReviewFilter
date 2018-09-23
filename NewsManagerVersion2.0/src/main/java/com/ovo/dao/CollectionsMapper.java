package com.ovo.dao;

import com.ovo.bean.Collections;
import com.ovo.bean.CollectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionsMapper {
    long countByExample(CollectionsExample example);

    int deleteByExample(CollectionsExample example);

    int deleteByPrimaryKey(String collectionsId);
    
    int deleteByNewsId(String newsId);

    int insert(Collections record);

    int insertSelective(Collections record);

    List<Collections> selectByExample(CollectionsExample example);

    Collections selectByPrimaryKey(String collectionsId);

    int updateByExampleSelective(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByExample(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);

	void deleteBynewsIdusersId(String newsId, String usersId);

	Collections selectBynewsIdusersId(String newsId, String usersId);

	List<String> selectnewsIdByusersId(String usersId);
}