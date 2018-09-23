package com.ovo.dao;

import com.ovo.bean.Admin;
import com.ovo.bean.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin login(@Param("admin_ID") String admin_ID, @Param("password") String password);

    boolean register(@Param("admin_ID") String admin_ID, 
    @Param("password") String password, @Param("name") String name);
    
    String findAdminByAdminId(@Param("admin_ID") String admin_ID);
    
    int adminedit(@Param("admin_ID") String admin_ID, @Param("password") String password);
}