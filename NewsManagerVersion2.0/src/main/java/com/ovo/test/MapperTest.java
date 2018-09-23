package com.ovo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ovo.dao.AdminMapper;
import com.ovo.dao.CollectionsMapper;
import com.ovo.dao.CommentsMapper;
import com.ovo.dao.Comments_likeMapper;
import com.ovo.dao.LikesMapper;
import com.ovo.dao.NewsMapper;
import com.ovo.dao.SharingsMapper;
import com.ovo.dao.UsersMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	UsersMapper likesmapper;	
	@Test
	
	public void testnews(){
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		AdminMapper bean = ioc.getBean(AdminMapper.class);
		System.out.println(likesmapper);
	}
}
