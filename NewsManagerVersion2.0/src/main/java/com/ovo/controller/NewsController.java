package com.ovo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovo.bean.Collections;
import com.ovo.bean.Comment;
import com.ovo.bean.Comments;
import com.ovo.bean.Comments_like;
import com.ovo.bean.Comments_name;
import com.ovo.bean.Likes;
import com.ovo.bean.Md5;
import com.ovo.bean.Msg;
import com.ovo.bean.News;
import com.ovo.bean.Sharings;
import com.ovo.bean.Users;
import com.ovo.service.NewsService;

@Controller

public class NewsController {
	@Autowired
	NewsService newsservice;
	@RequestMapping("/gongzuozixun/news")
	@ResponseBody
	public Msg getgongzuozixunnews(@RequestParam(value="pn" ,defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<News> news=newsservice.getgongzuozixunnews();
		for (int i = 0; i < news.size(); i++) {
            Date date = news.get(i).getRealseTime();
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(date);
            news.get(i).setRealseTime1(nowTime);
        }
		PageInfo page=new PageInfo(news,5); 
		return Msg.success().add("page", page);
		
	}
	@RequestMapping("/shenghuozixun/news")
	@ResponseBody
	public Msg getshenghuozixunnews(@RequestParam(value="pn" ,defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<News> news=newsservice.getshenghuozixunnews();
		for (int i = 0; i < news.size(); i++) {
            Date date = news.get(i).getRealseTime();
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(date);
            news.get(i).setRealseTime1(nowTime);
        }
		PageInfo page=new PageInfo(news,5); 
		return Msg.success().add("page", page);
		
	}
	@RequestMapping("/xuexijiaoliu/news")
	@ResponseBody
	public Msg getxuexijiaoliunews(@RequestParam(value="pn" ,defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<News> news=newsservice.getxuexijiaoliunews();
		for (int i = 0; i < news.size(); i++) {
            Date date = news.get(i).getRealseTime();
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(date);
            news.get(i).setRealseTime1(nowTime);
        }
		PageInfo page=new PageInfo(news,5); 
		return Msg.success().add("page", page);
		
	}
	@ResponseBody
	@RequestMapping(value="/user12/{ids}",method=RequestMethod.DELETE)
	public Msg deleteuserById(@PathVariable("ids")String ids){
		System.out.println("删除");
		newsservice.deleteuser(ids);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping(value="/comment/{ids}",method=RequestMethod.DELETE)
	public Msg deleteById(@PathVariable("ids")String ids){
		System.out.println("删除");
		newsservice.deletecomment(ids);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping(value="/user/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmpById(@PathVariable("ids")String ids){
		System.out.println("删除");
		newsservice.deletenews(ids);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping(value="/new/{newsId}",method=RequestMethod.PUT)
	public Msg savenews(News news,HttpServletRequest request){
		newsservice.updatenews(news);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping(value="/user12/{usersId}",method=RequestMethod.PUT)
	public Msg saveuser(Users user,HttpServletRequest request){
		newsservice.updateuser(user);
		return Msg.success();
	}
	//id查询
	@RequestMapping(value="/new/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getUser(@PathVariable("id")String id){
		News news = newsservice.getnews(id);
		return Msg.success().add("news", news);
	}
	@RequestMapping(value="/user12/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")String id){
		Users user = newsservice.getuserInfo(id);
		return Msg.success().add("user", user);
	}
	//检查新闻ID
	@ResponseBody
	@RequestMapping("/checknewsId")
	public Msg checknewsId(@RequestParam("newsId")String newsId){
		if(newsId.equals("")){
			return Msg.fail().add("va_msg","新闻ID不能为空");
		}
		String regx="(^[0-9]{10}$)";
		if(!(newsId.matches(regx))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","新闻ID必须是10位数字");
		}
		//数据库用户名重复校验
		boolean b =newsservice.checknewsId(newsId);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "新闻ID已占用");
		}
	}
	//检查新闻ID
		@ResponseBody
		@RequestMapping("/checkuserid")
		public Msg checkuserId(@RequestParam("title")String title){
			if(title.equals("")){
				return Msg.fail().add("va_msg","用户ID不能为空");
			}
			String regx="(^[0-9]{10}$)";
			if(!(title.matches(regx))){
				System.out.println("不可用");
				return Msg.fail().add("va_msg","用户ID必须是10位数字");
			}
			//数据库用户名重复校验
			boolean b =newsservice.checkusersId(title);
			if(b){
				return Msg.success();
			}else{
				return Msg.fail().add("va_msg", "用户ID已占用");
			}
		}
	//检查标题
	@ResponseBody
	@RequestMapping("/checktitle")
	public Msg checktitle(@RequestParam("title")String title){
		String regx="(^[a-zA-Z0-9_\u4e00-\u9fa5]{1,14}$)";
		if(!(title.matches(regx))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","新闻标题为1-14个字符(可以包含汉字，数字，字母和下划线)");
		}else{
			return Msg.success();
		}
	}
	@ResponseBody
	@RequestMapping("/checktitle1")
	public Msg checkusername(@RequestParam("title")String title){
		String regx="(^[a-zA-Z0-9_\u4e00-\u9fa5]{1,14}$)";
		if(!(title.matches(regx))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","用户名为1-14个字符(可以包含汉字，数字，字母和下划线)");
		}else{
			return Msg.success();
		}
	}
	@ResponseBody
	@RequestMapping("/phoneno")
	public Msg checkphoneno(@RequestParam("title")String title){
		String regx="(^[0-9]{11}$)";
		if(!(title.matches(regx))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","电话号码为11位数字");
		}else{
			return Msg.success();
		}
	}
	//检查标题
	@ResponseBody
	@RequestMapping("/checknewsContent")
	public Msg checknewsContent(@RequestParam("newsContent")String newsContent){
		//先判断用户名是否是合法的表达式
		String regx="^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$";
		if(!(newsContent.matches(regx))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","新闻链接不合法");
		}else{
			return Msg.success();
		}
	}
	//发布新闻
	@RequestMapping(value="new",method=RequestMethod.POST) //定义为POST请求
	@ResponseBody
	public Msg savenews(@Valid News news,BindingResult result){
		if(result.hasErrors()){
			Map<String,Object> map= new HashMap<>();
			//校验失败，应该返回失败，在模态框中显示校验失败的信息
			List<FieldError> errors = result.getFieldErrors(); //提取出错误信息
			for(FieldError fieldError : errors){
				System.out.println("错误的字段名:"+ fieldError.getField());  
				System.out.println("错误信息:"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			if(news.getNewsId().equals(null)|news.getNewsId().equals("")){
				return Msg.fail().add("va_msg1","新闻ID不能为空").add("va_msg2","新闻标题可用").add("va_msg3","新闻链接可用");
			}
			if(news.getTitle().equals(null)|news.getTitle().equals("")){
				return Msg.fail().add("va_msg1","新闻ID可用").add("va_msg2","新闻标题不能为空").add("va_msg3","新闻链接可用");
			}
			if(news.getNewsContent().equals(null)|news.getNewsContent().equals("")){
				return Msg.fail().add("va_msg1","新闻ID可用").add("va_msg2","新闻标题可用").add("va_msg3","新闻链接不能为空");
			}
			newsservice.savenews(news); 
			return Msg.success();
		}
	}
	//adduser
		@RequestMapping(value="user123",method=RequestMethod.POST) //定义为POST请求
		@ResponseBody
		public Msg adduser(@Valid Users user,BindingResult result){
			if(result.hasErrors()){
				Map<String,Object> map= new HashMap<>();
				//校验失败，应该返回失败，在模态框中显示校验失败的信息
				List<FieldError> errors = result.getFieldErrors(); //提取出错误信息
				for(FieldError fieldError : errors){
					System.out.println("错误的字段名:"+ fieldError.getField());  
					System.out.println("错误信息:"+fieldError.getDefaultMessage());
					map.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
				return Msg.fail().add("errorFields", map);
			}else{
				if (!user.getPassword().equals(user.getPassword1())){
					return Msg.fail().add("va_msg","两次密码不一致");
				}
				if(user.getUsersId().equals(null)|user.getUsersId().equals("")){
					return Msg.fail().add("va_msg1","用户ID不能为空").add("va_msg2","用户名可用").add("va_msg3","密码可用");
				}
				if(user.getName().equals(null)|user.getName().equals("")){
					return Msg.fail().add("va_msg1","用户ID可用").add("va_msg2","用户名不能为空").add("va_msg3","密码可用");
				}
				if(user.getPassword().equals(null)|user.getPassword().equals("")){
					return Msg.fail().add("va_msg1","用户ID可用").add("va_msg2","用户名可用").add("va_msg3","密码不能为空");
				}
				Md5 MD5 = new Md5();
				System.out.println("改之前：" + user.getPassword());
				user.setPassword(MD5.MD5(user.getPassword()));
				System.out.println("改之后：" + user.getPassword());
				newsservice.saveusers(user); 
				return Msg.success();
			}
		}
	//查询新闻数据 分页查询
	@RequestMapping("/news")
	@ResponseBody
	public Msg getnews(@RequestParam(value="pn" ,defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<News> news=newsservice.getAll();
		for (int i = 0; i < news.size(); i++) {
            Date date = news.get(i).getRealseTime();
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(date);
            news.get(i).setRealseTime1(nowTime);
        }
		PageInfo page=new PageInfo(news,5); 
		return Msg.success().add("page", page);
		
	}
	@RequestMapping("/user12")
	@ResponseBody
	public Msg getuser12(@RequestParam(value="pn" ,defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<Users> user=newsservice.getallusers();
		PageInfo page=new PageInfo(user,5); 
		return Msg.success().add("page", page);
		
	}
	//查询新闻数据 分页查询
	@RequestMapping("/comments")
	@ResponseBody
	public Msg getcomments(@RequestParam(value="pn" ,defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<Comments> commentslist=newsservice.getcomments();
		for (int i = 0; i < commentslist.size(); i++) {
			Date date = commentslist.get(i).getCommentTime();
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(date);
            commentslist.get(i).setCommentTime1(nowTime);
            String rs1=commentslist.get(i).getNewsId();
            String rs2=commentslist.get(i).getUsersId();
            commentslist.get(i).setNewstitle(newsservice.gettitleBynewsId(rs1));
            commentslist.get(i).setUsername(newsservice.getnameByusersId(rs2));
        }
		PageInfo page=new PageInfo(commentslist,5); 
		return Msg.success().add("page", page);		
	}
	//excel//excel daoru
	@RequestMapping(value = "/importUsers",method = RequestMethod.POST)
	@ResponseBody
    public int importUsers(HttpServletRequest request, Model model,
            @RequestParam("file") MultipartFile file){
		System.out.println("进入importuser_controller");
        //获取文件名
        String name=file.getOriginalFilename();
        //判断文件大小、即名称
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) return 0;
        try {
            //把文件转换成字节流形式
            InputStream in = file.getInputStream();
            int records = newsservice.importUsers(name,file);
            return records;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //return "redirect:/yonghuguanli.jsp";
        return 0;
    }
	
	//anzhuo跳转登录
	@ResponseBody
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public Msg userlogin(@RequestBody String usersId,@RequestBody String password,final HttpServletRequest request,final HttpServletResponse response) throws IOException {
		Md5 MD5 = new Md5();
		String passwordByMd5 = MD5.MD5(password);
		System.out.println("userpassword: " + password);
		System.out.println("userpassword_passwordByMd5: " + passwordByMd5);
		boolean count = newsservice.userlogin(usersId,passwordByMd5);
        if (count == true) {
        	Users user=newsservice.getuserInfo(usersId);
        	return Msg.success().add("user", user);
        } else {
        	return Msg.fail();
        }
	}
	@ResponseBody
	@RequestMapping(value ="/androidgetnews",method = RequestMethod.GET)
	public Msg androidgetnews(final HttpServletRequest request,final HttpServletResponse response) throws IOException {
        System.out.println("666666");
        List<News> news=newsservice.getAllByrealseTime();
        if (news.get(0).equals(null)){
        	return Msg.fail();
        }else{
        	return Msg.success().add("news", news);
        }
	}
	@ResponseBody
	@RequestMapping(value ="/getnewsBynewsType1",method = RequestMethod.POST)
	public Msg getnewsBynewsType1(@RequestBody String newsType1,final HttpServletRequest request,final HttpServletResponse response) throws IOException {
        System.out.println(newsType1);
        List<News> news=newsservice.getnewsBynewsType1(newsType1);
        if (news.get(0).equals(null)){
        	return Msg.fail();
        }else{
        	return Msg.success().add("news", news);
        }
	}
	@ResponseBody
	@RequestMapping(value ="/androidgetuserInfo",method = RequestMethod.POST)
	public Msg androidgetuserInfo(@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException {
        System.out.println("666644");
	        Users user=newsservice.getuserInfo(usersId);
        if (user.equals(null)){
        	return Msg.fail();
        }else{
        	return Msg.success().add("user", user);
        }
	}
	@ResponseBody
	@RequestMapping(value ="/androidupdateuserInfo",method = RequestMethod.POST)
	public Msg androidupdateuserInfo(@RequestBody String state,@RequestBody String usersId,@RequestBody String name,
			@RequestBody String password,@RequestBody String phoneNumber,
			@RequestBody String eMail,@RequestBody String sex,
			final HttpServletRequest request,final HttpServletResponse response) throws IOException {
        System.out.println("666633");
        if (state.equals("1")){
        	Md5 MD5 = new Md5();
        	password = Md5.MD5(password);
        }
        if(usersId.equals("")|usersId.equals(null)){
			return Msg.fail().add("va_msg","用户ID不能为空");
		}
		String regx="(^[0-9]{10}$)";
		if(!(usersId.matches(regx))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","用户ID必须是10位数字");
		}
		String regx1="(^[0-9]{11}$)";
		if(!(phoneNumber.matches(regx1))){
			System.out.println("不可用");
			return Msg.fail().add("va_msg","用户电话号码必须是11位数字");
		}
		if(sex.equals("男")||sex.equals("女")){
			Users user=new Users();
			user.setUsersId(usersId);
			user.setName(name);
			user.setPassword(password);
			user.setPhoneNumber(phoneNumber);
			user.seteMail(eMail);
			user.setSex(sex);
			System.out.println(name);
	        newsservice.updateuserInfo(user);
	        return Msg.success();
		}else{
			System.out.println("不可用");
			return Msg.fail().add("va_msg","用户性别必须是男或女");
		}
	}
	//按评论时间排序
	@ResponseBody
	@RequestMapping(value ="/androidgetcommentByuserId",method = RequestMethod.POST)
	public Msg androidgetcommentByuserId(@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException {
        System.out.println("666644");
        List<Comments> comments=newsservice.getcommentByuserId(usersId);
        if (comments.get(0).equals(null)){
        	return Msg.fail();
        }else{
        	return Msg.success().add("comments", comments);
        }
	}
	//按新闻获取评论 评论时间排序
	@ResponseBody
	@RequestMapping(value ="/androidgetcommentBynewsId",method = RequestMethod.POST)
	public Msg androidgetcommentBynewsId(@RequestBody String newsId,final HttpServletRequest request,final HttpServletResponse response) throws IOException {
		System.out.println("666633");
		System.out.println(newsId);
		List<Comments> comments=newsservice.getcommentBynewsId(newsId);
		List<Comments_name> comments_name=new ArrayList<Comments_name>();
		for (int i = 0; i < comments.size(); i++) {
			Comments_name commentsname=new Comments_name();
			commentsname.setLikes(comments.get(i).getLikes());
			commentsname.setCommentsId(comments.get(i).getCommentsId());
			commentsname.setCommentContent(comments.get(i).getCommentContent());
			commentsname.setCommentTime(comments.get(i).getCommentTime());
			commentsname.setCommentType(comments.get(i).getCommentType());
			commentsname.setNewsId(comments.get(i).getNewsId());
			commentsname.setUsersId(comments.get(i).getUsersId());
			commentsname.setName(newsservice.getnameByusersId(comments.get(i).getUsersId()));
			comments_name.add(i, commentsname);
		} 
		if (comments_name.equals(null)){
			return Msg.fail().add("va_msg", "新闻无已审核评论");
		}else{
			return Msg.success().add("comments_name", comments_name);
		}
	}
	//发表评论
	@ResponseBody
	@RequestMapping(value ="/androidsetcomment",method = RequestMethod.POST)
	public Msg androidsetcomment(@RequestBody String commentContent,@RequestBody String newsId,@RequestBody String usersId,
			final HttpServletRequest request,final HttpServletResponse response) throws IOException {
		System.out.println("666622");
		Comments comments=new Comments();
		comments.setNewsId(newsId);
		comments.setUsersId(usersId);
		comments.setLikes(0);
		comments.setCommentType("待审核");
		comments.setCommentContent(commentContent);
		Date date=new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Date time = null;
		try {
			time = sdf.parse(nowTime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		comments.setCommentTime(time);
		if(newsservice.getnews(comments.getNewsId())==null){
			return Msg.fail().add("va_msg","无此新闻，评论失败");
		}else if(newsservice.getuserInfo(comments.getUsersId())==null){
			return Msg.fail().add("va_msg","无此用户，评论失败");
		}
		newsservice.setcomment(comments);
		return Msg.success();
	}
	//点赞👍
	@ResponseBody
	@RequestMapping(value ="/androidlikes",method = RequestMethod.POST)
	public Msg androidlikes(@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		boolean count=newsservice.iflikes(newsId,usersId);
		if (count==true){
			return Msg.fail().add("va_msg", "已点赞，不可重复点赞");
		}
		Likes likes=new Likes();
		likes.setNewsId(newsId);
		likes.setUsersId(usersId);
		Date date=new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Date time = null;
		try {
			time = sdf.parse(nowTime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		likes.setLikesTime(time);
		if(newsservice.getnews(likes.getNewsId())==null){
			return Msg.fail().add("va_msg","无此新闻，点赞失败");
		}else if(newsservice.getuserInfo(likes.getUsersId())==null){
			return Msg.fail().add("va_msg","无此用户，点赞失败");
		}
		newsservice.setlikes(likes);
		return Msg.success();
	}
	//评论点赞
	@ResponseBody
	@RequestMapping(value ="/androidcommentslikes",method = RequestMethod.POST)
	public Msg androidcommentslikes(@RequestBody int commentsId,@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		Comments_like commentslike=new Comments_like();
		commentslike.setCommentsId(commentsId);
		commentslike.setNewsId(newsId);
		commentslike.setUsersId(usersId);
		if(newsservice.getnews(commentslike.getNewsId())==null){
			return Msg.fail().add("va_msg","无此新闻，对该评论点赞失败");
		}else if(newsservice.getuserInfo(commentslike.getUsersId())==null){
			return Msg.fail().add("va_msg","无此用户，对该评论点赞失败");
		}else if(newsservice.getcommentBycommentsid(commentsId)==null){
			return Msg.fail().add("va_msg","无此评论，对该评论点赞失败");
		}
		newsservice.setcommentslike(commentslike);
		return Msg.success();

	}
	//分享
	@ResponseBody
	@RequestMapping(value ="/androidsharing",method = RequestMethod.POST)
	public Msg androidsharing(@RequestBody String newsId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		Sharings sharings=new Sharings();
		sharings.setNewsId(newsId);
		Date date=new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Date time = null;
		try {
			time = sdf.parse(nowTime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		sharings.setSharingsTime(time);
		if(newsservice.getnews(sharings.getNewsId())==null){
			return Msg.fail().add("va_msg","无此新闻，分享失败");
		}
		newsservice.setsharings(sharings);
		return Msg.success();
	}
	//收藏
	@ResponseBody
	@RequestMapping(value ="/androidcollection",method = RequestMethod.POST)
	public Msg androidcollection(@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		boolean count=newsservice.ifcollections(newsId,usersId);
		if (count==true){
			return Msg.fail().add("va_msg", "已收藏，不可重复收藏");
		}
		Collections collections=new Collections();
		collections.setNewsId(newsId);
		collections.setUsersId(usersId);
		Date date=new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(date);
	    Date time = null;
		try {
			time = sdf.parse(nowTime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		collections.setConllectionsTime(time);
		if(newsservice.getnews(collections.getNewsId())==null){
			return Msg.fail().add("va_msg","无此新闻，收藏失败");
		}else if(newsservice.getuserInfo(collections.getUsersId())==null){
			return Msg.fail().add("va_msg","无此用户，收藏失败");
		}
		newsservice.setcollections(collections);
		return Msg.success();
	}
	//删除评论
	@ResponseBody
	@RequestMapping(value ="/androiddecomments",method = RequestMethod.POST)
	public Msg androiddecomments(@RequestBody String commentsId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		int commentId=Integer.parseInt(commentsId);
		System.out.println(commentId);
		newsservice.decomments(commentId);
		return Msg.success();
	}
	//取消收藏
	@ResponseBody
	@RequestMapping(value ="/androiddecollections",method = RequestMethod.POST)
	public Msg androiddecollections(@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		newsservice.decollections(newsId,usersId);
		return Msg.success();
	}
	//取消新闻点赞
	@ResponseBody
	@RequestMapping(value ="/androiddelikes",method = RequestMethod.POST)
	public Msg androiddelikes(@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		newsservice.delikes(newsId,usersId);
		return Msg.success();
	}
	//取消新闻点赞
	@ResponseBody
	@RequestMapping(value ="/androiddecommentslikes",method = RequestMethod.POST)
	public Msg decommentslikes(@RequestBody String commentsId,@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		int commentId=Integer.valueOf(commentsId).intValue();
		newsservice.decommentslikes(commentId,newsId,usersId);
		return Msg.success();
	}
	//判断用户点赞新闻
	@ResponseBody
	@RequestMapping(value ="/androidiflikes",method = RequestMethod.POST)
	public Msg iflikes(@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		boolean count=newsservice.iflikes(newsId,usersId);
		if (count==true){
			return Msg.success();
		}else{
			return Msg.fail();
		}
	}
	//判断用户收藏新闻
	@ResponseBody
	@RequestMapping(value ="/androidifcollections",method = RequestMethod.POST)
	public Msg ifcollections(@RequestBody String newsId,@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		boolean count=newsservice.ifcollections(newsId,usersId);
		if (count==true){
			return Msg.success();
		}else{
			return Msg.fail();
		}
	}
	//返回收藏的新闻列表
	@ResponseBody
	@RequestMapping(value ="/androiduserslikes",method = RequestMethod.POST)
	public Msg userslikes(@RequestBody String usersId,final HttpServletRequest request,final HttpServletResponse response) throws IOException{
		List <String> newslist=newsservice.selectnewsIdByusersId(usersId);
		System.out.println(newslist);
		List <News> news=new ArrayList<News>();
		for (int i = 0; i < newslist.size(); i++) {
			String str = newslist.get(i);
			System.out.println(str);
			news.add(i, newsservice.getnews(str));
		} 
		return Msg.success().add("news", news);
	}
	/*验证登录
	 *
	 * 使用 @ResponseBody 在ajax异步获取数据时使用。返回0/1
	 *
	 */
	@RequestMapping(value = "login_check", method = RequestMethod.POST)
	@ResponseBody
	public int login(HttpServletRequest request,String adminId, String password) {
		Md5 MD5 = new Md5();
	    String passwordByMd5 = MD5.MD5(password);
	    boolean count = newsservice.login(adminId, passwordByMd5);
	    int message;
	    if (count == true) {
	    	request.getSession().setAttribute("adminId",adminId);
	        message = 1;
	    } else {
	        message = 0;
	    }
	    return message;
	}

	//跳转注册
	@RequestMapping(value = "toAdd")
	public String toAdd() {
	    return "register";
	}

	//实现注册
	@RequestMapping(value = "implAdd", method = RequestMethod.POST)
	@ResponseBody
	public int add(@RequestParam("adminId")String adminId, @RequestParam("password")String password, @RequestParam("name")String name) {
		System.out.println("注册控制层");
//		System.out.println("admin: " + adminId);
//		System.out.println("password: " + password);
//		System.out.println("name: " + name);
		Md5 MD5 = new Md5();
	    String passwordByMd5 = MD5.MD5(password);
	    System.out.println("passwordByMd5: " + passwordByMd5);
	    String findAdminByAdminId = newsservice.findAdminByAdminId(adminId);
	    System.out.println("findAdminByAdminId: " + findAdminByAdminId);
	    int message;
	    if (adminId.length() == 0 || name.length() == 0 || password.length() == 0) {
	        message = -1;
	        System.out.println("用户信息输入信息有误");
	    } else if (findAdminByAdminId.equals("0")) {
	    	newsservice.register(adminId, passwordByMd5, name);
	        message = 1;
	        System.out.println("可以注册");
	    } else {
	        System.out.println("用户存在");
	        message = 0;
	    }
	    return message;
	}
	
	//管理员密码修改
	
	@RequestMapping(value = "/admin_edit", method = RequestMethod.POST)
	@ResponseBody
	public int AdminEdit(HttpServletRequest request,String password,String oldpassword){
		System.out.println("adminedit_controller");
		Md5 MD5 = new Md5();
	    String passwordByMd5 = MD5.MD5(password);	
	    String oldpasswordByMd5 = MD5.MD5(oldpassword);
	    System.out.println("oldpassword: " + oldpassword);
	    String adminId = (String) request.getSession().getAttribute("adminId");
	    boolean countold = newsservice.login(adminId, oldpasswordByMd5);
	    if(countold == false){
	    	return -1;
	    }
	    System.out.println("adminId: " + adminId);
	    System.out.println("password: " + password);
	    System.out.println("passwordByMd5: " + passwordByMd5);
	    boolean count = newsservice.adminedit(adminId, passwordByMd5);
	    int message;
	    if (count == true) {
	        message = 1;
	    } else {
	        message = 0;
	    }
		return message;
	}
	
	//管理员退出登录
	@RequestMapping(value = "/admin_quit", method = RequestMethod.POST)
	@ResponseBody
	public void AdminQuit(HttpServletRequest request){
		System.out.println("adminqiut_controller");
		request.getSession().setAttribute("adminId",null);
	}
	
}
