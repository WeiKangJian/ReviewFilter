package com.ovo.dao;

import com.ovo.bean.Comments;
import com.ovo.bean.CommentsExample;
import com.ovo.bean.Comments_name;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {

	List<Comments> selectByuserId(String usersId);
	List<Comments> selectBynewsId(String newsId);
	int insertSelective(Comments comments);
	Comments selectBycommentsId(int commentsId);
	void deleteByPrimaryKey(int commentsId);
	List<Comments> getall();
}
