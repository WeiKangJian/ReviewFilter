package com.ovo.dao;

import com.ovo.bean.Comments_like;
import com.ovo.bean.Comments_likeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Comments_likeMapper {
    long countByExample(Comments_likeExample example);

    int deleteByExample(Comments_likeExample example);

    int deleteByPrimaryKey(String actsId);
    
    int deleteByNewsId(String newsId);

    int insert(Comments_like record);

    int insertSelective(Comments_like record);

    List<Comments_like> selectByExample(Comments_likeExample example);

    Comments_like selectByPrimaryKey(String actsId);

    int updateByExampleSelective(@Param("record") Comments_like record, @Param("example") Comments_likeExample example);

    int updateByExample(@Param("record") Comments_like record, @Param("example") Comments_likeExample example);

    int updateByPrimaryKeySelective(Comments_like record);

    int updateByPrimaryKey(Comments_like record);

	void deleteBycommentsIdnewsIdusersId(int commentsId, String newsId, String usersId);
}