package com.ovo.dao;

import com.ovo.bean.Users;
import com.ovo.bean.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int insert(Users record);

    Users selectByPrimaryKey(String usersId);
    
    Users selectByname(String name);
    
    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

	Users login(String arg0, String arg1);

	void updateByPrimaryKey(@Param("record") Users record);

	String getnameByusersId(String usersId);

	List<Users> getallusers();

	void deleteByPrimaryKey(String ids);

	void updateByPrimaryKey1(@Param("record") Users record);

}