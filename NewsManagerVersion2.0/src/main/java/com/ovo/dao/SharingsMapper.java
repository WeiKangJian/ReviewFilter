package com.ovo.dao;

import com.ovo.bean.Sharings;
import com.ovo.bean.SharingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SharingsMapper {
    long countByExample(SharingsExample example);

    int deleteByExample(SharingsExample example);

    int deleteByPrimaryKey(String sharingsId);

    int insert(Sharings record);

    int insertSelective(Sharings record);

    List<Sharings> selectByExample(SharingsExample example);

    Sharings selectByPrimaryKey(String sharingsId);

    int updateByExampleSelective(@Param("record") Sharings record, @Param("example") SharingsExample example);

    int updateByExample(@Param("record") Sharings record, @Param("example") SharingsExample example);

    int updateByPrimaryKeySelective(Sharings record);

    int updateByPrimaryKey(Sharings record);
}