package com.ovo.service;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ovo.bean.Admin;
import com.ovo.bean.Collections;
import com.ovo.bean.Comments;
import com.ovo.bean.Comments_like;
import com.ovo.bean.Comments_name;
import com.ovo.bean.Likes;
import com.ovo.bean.Md5;
import com.ovo.bean.Msg;
import com.ovo.bean.News;
import com.ovo.bean.NewsExample;
import com.ovo.bean.NewsExample.Criteria;
import com.ovo.bean.ReadExcel;
import com.ovo.bean.Sharings;
import com.ovo.bean.Users;
import com.ovo.dao.AdminMapper;
import com.ovo.dao.CollectionsMapper;
import com.ovo.dao.CommentsMapper;
import com.ovo.dao.Comments_likeMapper;
import com.ovo.dao.LikesMapper;
import com.ovo.dao.NewsMapper;
import com.ovo.dao.SharingsMapper;
import com.ovo.dao.UsersMapper;

import TrainAndCategorization.TextCategorizationMain;



@Service
public class NewsService {
	@Autowired
	NewsMapper newsmapper;
	@Autowired
	UsersMapper usersmapper;
	@Autowired
	AdminMapper adminmapper;
	@Autowired
	CommentsMapper commentsmapper;
	@Autowired
	LikesMapper likesmapper;
	@Autowired
	Comments_likeMapper commentslikemapper;
	@Autowired
	SharingsMapper sharingsmapper;
	@Autowired
	CollectionsMapper collectionsmapper;
	public boolean checknewsId(String newsId) {
		NewsExample example = new NewsExample();
		Criteria criteria=example.createCriteria();
		criteria.andNewsIdEqualTo(newsId);
		long count = newsmapper.countByExample(example); //通过名字看是否有这个记录数
		return count == 0;
	}
	public void setcomment(Comments comments) {
		String comment=comments.getCommentContent();
		TextCategorizationMain text=new TextCategorizationMain();
		try {
			boolean zz=text.predict(comment);
			if (zz==true){
				comments.setCommentType("已审核");
			}else{
				comments.setCommentType("未通过");
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		commentsmapper.insertSelective(comments);
	}
	public int importUsers(String name, MultipartFile file) {	
	    //处理EXCEL
	    ReadExcel readExcel=new ReadExcel();
	    //解析Excel，获得Excel里的数据集
	    List<Users> userlist =  readExcel.getExcelInfo(name,file);
	    //操作数据库，将uComplaintsList插入到数据库中即可
	    System.out.println("userlist_size: " + userlist.size());
	    int count = 0;
	    Users user = new Users();
	    for(int i = 0; i < userlist.size(); i++)
	    {
	    	String s1,s2,s3,s4,s5,s6;
	    	s1=userlist.get(i).getUsersId();
	    	s2=userlist.get(i).getName();
	    	s3=userlist.get(i).getPassword();
	    	s4=userlist.get(i).getPhoneNumber();
	    	s5=userlist.get(i).geteMail();
	    	s6=userlist.get(i).getSex();
	    	String regx="(^[0-9]{10}$)";
	    	if(!(s1.matches(regx))){
	    		continue;
			}
	    	String regx1="(^[0-9]{11}$)";
	    	if(!(s4.matches(regx1))){
	    		continue;
			}
	    	System.out.println("userpassword: " + s3);
	    	Md5 MD5 = new Md5();
	    	String passwordByMd5 = MD5.MD5(userlist.get(i).getPassword());
	    	//System.out.println("userpassword_passwordByMd5: " + passwordByMd5);
	    	user.setUsersId(userlist.get(i).getUsersId());
	    	user.setName(userlist.get(i).getName());
	    	user.setPassword(passwordByMd5);
	    	user.setPhoneNumber(userlist.get(i).getPhoneNumber());
	    	user.seteMail(userlist.get(i).geteMail());
	    	user.setSex(userlist.get(i).getSex());
	    	usersmapper.insert(user); //空指针错误
	    	count++;
	    }
	    System.out.println("count: " + count);
	    return (count);
	}
	//发布新闻
	public void savenews(News news) {
		// TODO Auto-generated method stub
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
		news.setLikes(0);
		news.setCollectonNum(0);
		news.setCommentNum(0);
		news.setSharingNum(0);
		news.setRealseTime(time);
		if (news.getNewsType1().equals("1")){
			news.setNewsType(1);
		}else if (news.getNewsType1().equals("2")){
			news.setNewsType(2);
		}else{
			news.setNewsType(3);
		}
		newsmapper.insertSelective(news); //不需要id
	}
	public List<Comments> getcomments() {
		// TODO Auto-generated method stub
		return commentsmapper.getall();
		
	}
	//分页查询
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return newsmapper.selectByExample(null);
	}
	public News getnews(String id) {
		// TODO 自动生成的方法存根
		News news=newsmapper.selectByPrimaryKey(id);
		if (news.getNewsType()==1){
			news.setNewsType1("1");
		}else if (news.getNewsType()==2){
			news.setNewsType1("2");
		}else{
			news.setNewsType1("3");
		}
		return news;
	}
	public void updatenews(News news) {
		// TODO 自动生成的方法存根
		if (news.getNewsType1().equals("1")){
			news.setNewsType(1);
		}else if (news.getNewsType1().equals("2")){
			news.setNewsType(2);
		}else{
			news.setNewsType(3);
		}
		newsmapper.updateByPrimaryKeySelective(news);
	}
	public void deletenews(String newsId) {
		// TODO 自动生成的方法存根
		newsmapper.deleteByPrimaryKey(newsId);
		
	}
	public List<News> getgongzuozixunnews() {
		// TODO 自动生成的方法存根
		return newsmapper.selectBynewsType("1");
	}
	public List<News> getshenghuozixunnews() {
		// TODO 自动生成的方法存根
		return newsmapper.selectBynewsType("3");
	}
	public List<News> getxuexijiaoliunews() {
		// TODO 自动生成的方法存根
		return newsmapper.selectBynewsType("2");
	}
	

public boolean login(String adminId, String password) {
    if (adminmapper.login(adminId, password) != null) {
        return true;
    } else {
        return false;
    }
}


//admin修改密码
public boolean adminedit(String adminId, String password){
	System.out.println("adminedit_service");
	if(adminmapper.adminedit(adminId,password) != 0)
	{
		System.out.println("adminedit_service_success");
		return true;
	}
	return false;
}

public void register(String adminId, String password, String name) {
	Admin admin = new Admin();
	admin.setAdminId(adminId);
	admin.setPassword(password);
	admin.setName(name);
	System.out.println("服务层:");
	System.out.println("admin: " + admin.getAdminId());
	System.out.println("password: " + admin.getPassword());
	System.out.println("name: " + admin.getName());
	adminmapper.insert(admin);
}	
	
public String findAdminByAdminId(String adminId){
	return(adminmapper.findAdminByAdminId(adminId));
}
public boolean userlogin(String usersId, String password) {
	// TODO 自动生成的方法存根
	if (usersmapper.login(usersId, password) != null) {
        return true;
    } else {
        return false;
    }
}
public List<News> getAllByrealseTime() {
	// TODO 自动生成的方法存根
	return newsmapper.selectByrealseTime();
}
public List<News> getnewsBynewsType1(String newsType1) {
	// TODO 自动生成的方法存根
	return newsmapper.selectBynewsType(newsType1);
}
public Users getuserInfo(String usersId) {
	// TODO 自动生成的方法存根
	return usersmapper.selectByPrimaryKey(usersId);
}
public void updateuserInfo(Users user) {
	// TODO 自动生成的方法存根
	usersmapper.updateByPrimaryKey(user);
}
public void updateuser(Users user) {
	// TODO 自动生成的方法存根
	usersmapper.updateByPrimaryKey1(user);
}
public List<Comments> getcommentByuserId(String usersId) {
	// TODO 自动生成的方法存根
	return commentsmapper.selectByuserId(usersId);
}
public  List<Comments> getcommentBynewsId(String newsId) {
	// TODO 自动生成的方法存根
	return commentsmapper.selectBynewsId(newsId);
}
public void setlikes(Likes likes) {
	// TODO 自动生成的方法存根
	likesmapper.insertSelective(likes);
}
public Comments getcommentBycommentsid(int commentsId) {
	// TODO 自动生成的方法存根
	return commentsmapper.selectBycommentsId(commentsId);
}
public void setcommentslike(Comments_like commentslike) {
	// TODO 自动生成的方法存根
	commentslikemapper.insertSelective(commentslike);
}
public void setsharings(Sharings sharings) {
	// TODO 自动生成的方法存根
	sharingsmapper.insertSelective(sharings);
}
public void setcollections(Collections collections) {
	// TODO 自动生成的方法存根
	collectionsmapper.insertSelective(collections);
}
public void decomments(int commentsId) {
	// TODO 自动生成的方法存根
	commentsmapper.deleteByPrimaryKey(commentsId);
}
public void decollections(String newsId, String usersId) {
	// TODO 自动生成的方法存根
	collectionsmapper.deleteBynewsIdusersId(newsId,usersId);
}
public void delikes(String newsId, String usersId) {
	// TODO 自动生成的方法存根
	likesmapper.deleteBynewsIdusersId(newsId,usersId);
}
public void decommentslikes(int commentsId, String newsId, String usersId) {
	// TODO 自动生成的方法存根
	commentslikemapper.deleteBycommentsIdnewsIdusersId(commentsId,newsId,usersId);
}
public boolean iflikes(String newsId, String usersId) {
	// TODO 自动生成的方法存根
	if (likesmapper.selectBynewsIdusersId(newsId,usersId)!=null){
		return true;
	}else{
		return false;
	}
}
public List<String> selectnewsIdByusersId(String usersId) {
	// TODO 自动生成的方法存根
	return collectionsmapper.selectnewsIdByusersId(usersId);
}
public boolean ifcollections(String newsId, String usersId) {
	// TODO 自动生成的方法存根
	if (collectionsmapper.selectBynewsIdusersId(newsId,usersId)!=null){
		return true;
	}else{
		return false;
	}
}
public String getnameByusersId(String usersId) {
	// TODO 自动生成的方法存根
	return usersmapper.getnameByusersId(usersId);
}
public String gettitleBynewsId(String newsId) {
	// TODO 自动生成的方法存根
	return newsmapper.gettitleBynewsId(newsId);
}
public void deletecomment(String ids) {
	// TODO 自动生成的方法存根
	System.out.println(ids);
	int commentsId=Integer.parseInt(ids);
	commentsmapper.deleteByPrimaryKey(commentsId);
}
public List<Users> getallusers() {
	// TODO 自动生成的方法存根
	return usersmapper.getallusers();
}
public void deleteuser(String ids) {
	// TODO 自动生成的方法存根
	usersmapper.deleteByPrimaryKey(ids);
}
public void saveusers(Users user) {
	// TODO 自动生成的方法存根
	usersmapper.insertSelective(user);
}
public boolean checkusersId(String title) {
	// TODO 自动生成的方法存根
	Users user=usersmapper.selectByPrimaryKey(title);
	if (user==null){
		return true;
	}else{
		return false;
	}
}
}
