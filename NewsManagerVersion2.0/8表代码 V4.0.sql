create table users (                                 /*用户表*/
users_ID char(10) not null primary key,
name varchar(12),
password varchar(11),
phone_number char(11),
E_mail varchar(10),
sex varchar(100),
address varchar(20),
QQ varchar(11)
self_introduction varchar(50)
)DEFAULT CHARSET=utf8;

insert into users values('1000000001','赵一','123456','12345678912','001@qq.com','男','北京理工大学','123456789','北理工软件工程');


create table admin(                                  /*管理员表*/
admin_ID char(10) not null primary key,
name varchar(12),
password varchar(10)
)DEFAULT CHARSET=utf8;

insert into admin values('2000000001','魏一','123456');
delete from admin where admin_ID='2000000001'

create table news (                                   /*新闻表*/
news_ID char(10) not null primary key,
title varchar(100),
realse_time datetime,
news_type int(3),
news_content varchar(255),
news_state  varchar(10),
likes int(5),
collecton_num int(5),
sharing_num int(5),
comment_num int(5)
)DEFAULT CHARSET=utf8;

insert into news values('3000000001','新闻1','2018-09-01 8:00:00','001','https://www.baidu.com/s?tn=80035161_2_dg&wd=mysql','已审核','1','1','1','1') ;


create table comments (                              /*评论表*/
comments_ID char(10) not null primary key,
news_ID char(10)not null ,
users_ID char(10)not null,
comment_time datetime,
comment_content varchar(100),
comment_state varchar(100),
likes int(5),
picture blob,
foreign key(news_ID) references news(news_ID),
foreign key(users_ID) references users(users_ID)
)DEFAULT CHARSET=utf8;

insert into comments values('4000000001','3000000001','1000000001','2018-09-04 8:00:00','勇士屠龙','已审核','5','');           

create table likes (                                   /*点赞表*/
likes_ID char(10) not null primary key,
news_ID char(10) not null,
users_ID char(10) not null,
likes_time datetime,
foreign key(news_ID) references news(news_ID),
foreign key(users_ID) references users(users_ID)
)DEFAULT CHARSET=utf8;

insert into likes values('5000000001','3000000001','1000000001','2018-09-04 8:00:00');

create table collections (                               /*收藏表*/
collections_ID char(10) not null primary key,
news_ID char(10) not null,
users_ID char(10) not null,
conllections_time datetime,
foreign key(news_ID) references news(news_ID),
foreign key(users_ID) references users(users_ID)
)DEFAULT CHARSET=utf8;

insert into collections values('6000000001','3000000001','1000000001','2018-09-04 8:00:00');

create table sharings (                                  /*分享表*/
sharings_ID char(10) not null primary key,
news_ID char(10) not null,
users_ID char(10) not null,
sharings_time datetime,
foreign key(news_ID) references news(news_ID),
foreign key(users_ID) references users(users_ID)
)DEFAULT CHARSET=utf8;

insert into sharings values('7000000001','3000000001','1000000001','2018-09-04 8:00:00');



create table comments_like(                                /*评论点赞表*/
acts_ID char(10) not null primary key,
comments_ID char(10) not null,
news_ID char(10) not null,
users_ID char(10) not null,
foreign key(comments_ID) references comments(comments_ID),
foreign key(news_ID) references news(news_ID),
foreign key(users_ID) references users(users_ID)
)DEFAULT CHARSET=utf8;

insert into comments_like values('8000000001','4000000001','3000000001','1000000001');

create trigger after_likes after insert on likes for each row
begin 
update news set likes = likes + 1 
where news.news_ID = new.news_ID;
end

create trigger after_sharings after insert on sharings for each row
begin 
update news set sharing_num = sharing_num + 1 
where news.news_ID = new.news_ID;
end

create trigger after_collections after insert on collections for each row
begin 
update news set collecton_num = collecton_num + 1 
where news.news_ID = new.news_ID;
end

create trigger after_comments after insert on comments for each row
begin 
update news set comment_num = comment_num + 1 
where news.news_ID = new.news_ID;
end

create trigger after_comments_like after insert on comments_like for each row
begin 
update comments set likes = likes + 1 
where comments.comments_ID = new.comments_ID;
end

create trigger news_delete_before_trigger before delete on news for each row            /*删除新闻 */
begin                                                                                   /* where条件里是old.ID不是news.ID ;后者的话查询条件为删除后的表，查不到 */
delete from comments where news_ID=old.news_ID;
delete from likes where news_ID=old.news_ID;
delete from collections where news_ID=old.news_ID;
delete from sharings where news_ID=old.news_ID;
delete from comments_like where news_ID=old.news_ID;
end

create trigger comments_delete_before_trigger before delete on comments for each row    /*删除评论 */
begin                                                                                      
delete from comments_like where comments_ID=old.comments_ID;
end

create trigger users_delete_before_trigger before delete on users for each row        /*删除用户 */
begin 
delete from comments where users_ID=old.users_ID;
delete from likes where users_ID=old.users_ID;
delete from collections where users_ID=old.users_ID;
delete from sharings where users_ID=old.users_ID;
delete from comments_like where users_ID=old.users_ID;
end


create procedure admin_check(in num_begin varchar(10),in num_end varchar(10)) /*存储过程 用于删除管理员信息*/
begin
delete from admin where admin.admin_ID<num_begin or admin.admin_ID>num_end;
end

call admin_check('2000000003','2000000007')         /*调用存储过程*/ 


create view comlike_infor/* 视图 所有评论信息，面向用户*/
as select news.title as 新闻标题,news.realse_time as 新闻发布时间,users.name as 评论者,comments.comment_content as 评论内容,comments.comment_time as 评论时间,comments.likes as 评论点赞数
from comments,news,users
where comments.news_ID=news.news_ID and comments.users_ID=users.users_ID and comments.comment_state='已审核';

select * from comlike_infor;      /*调用视图*/


create view comments_infor/* 视图  所有未审核的评论的所有信息，面向管理员*/
as select news.title as 新闻标题,news.realse_time as 新闻发布时间,users.users_ID as 评论者账号,users.name as 评论者,comments.comment_content as 评论内容,comments.comment_time as 评论时间
from comments,news,users
where comments.news_ID=news.news_ID and comments.users_ID=users.users_ID and comments.comment_state='未审核';

select * from comments_infor;