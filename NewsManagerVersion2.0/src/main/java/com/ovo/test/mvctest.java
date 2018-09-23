package com.ovo.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.ovo.bean.News;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
	
public class mvctest {
	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;
	@Before
	public void initMockMvc(){
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception{
		//模拟请求拿到返回值
		System.out.println("sadadadadada");
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/news").param("pn", "1")).andDo(MockMvcResultHandlers.print()).andReturn();
		//请求成功以后，请求域中会有pageInfo:我们可以取出pageinfo进行验证
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo)request.getAttribute("pageas");
		System.out.println(request.getAttribute("pageas"));
		System.out.println(result.getRequest());
		System.out.println("总页码:"+pi.getPages());
		System.out.println("总记录数:"+pi.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[]  nums= pi.getNavigatepageNums();
		for(int i:nums){
			System.out.println(" "+i);
		}
		
		//获取员工数据
		List<News> list= pi.getList();
		for(News user : list ){
			System.out.println("ID:" +user.getNewsId()+"==>Name:"+user.getNewsContent());
		}
		
	}
}
