package com.ovo.dao;

import com.ovo.bean.Likes;
import com.ovo.bean.LikesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikesMapper {
    long countByExample(LikesExample example);

    int deleteByExample(LikesExample example);

    int deleteByPrimaryKey(String likesId);

    int insert(Likes record);

    int insertSelective(Likes record);

    List<Likes> selectByExample(LikesExample example);

    Likes selectByPrimaryKey(String likesId);

    int updateByExampleSelective(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByExample(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);

	void deleteBynewsIdusersId(String newsId, String usersId);

	Likes selectBynewsIdusersId(String newsId, String usersId);

	List<String> selectnewsIdByusersId(String usersId);
}