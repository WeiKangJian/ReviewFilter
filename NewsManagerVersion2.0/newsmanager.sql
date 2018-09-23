/*
 Navicat MySQL Data Transfer

 Source Server         : mydb
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : newsmanager

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 14/09/2018 22:16:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('wkj12345', '123456', 'fcea920f7412b5da7be0cf42b8c93759');

-- ----------------------------
-- Table structure for collections
-- ----------------------------
DROP TABLE IF EXISTS `collections`;
CREATE TABLE `collections`  (
  `collections_ID` int(10) NOT NULL AUTO_INCREMENT,
  `news_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `users_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `conllections_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`collections_ID`) USING BTREE,
  INDEX `news_ID`(`news_ID`) USING BTREE,
  INDEX `collections_ibfk_2`(`users_ID`) USING BTREE,
  CONSTRAINT `collections_ibfk_1` FOREIGN KEY (`news_ID`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collections_ibfk_2` FOREIGN KEY (`users_ID`) REFERENCES `users` (`users_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collections
-- ----------------------------
INSERT INTO `collections` VALUES (72, '1000000002', '1000000003', '2018-09-12 23:42:18');
INSERT INTO `collections` VALUES (80, '1000000001', '1000000001', '2018-09-13 09:23:18');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `comments_ID` int(10) NOT NULL AUTO_INCREMENT,
  `news_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `users_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_time` datetime(0) NULL DEFAULT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `likes` int(5) NULL DEFAULT NULL,
  `comment_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comments_ID`) USING BTREE,
  INDEX `news_ID`(`news_ID`) USING BTREE,
  INDEX `comments_ID`(`comments_ID`) USING BTREE,
  INDEX `comments_ID_2`(`comments_ID`) USING BTREE,
  INDEX `comments_ID_3`(`comments_ID`) USING BTREE,
  INDEX `comments_ibfk_2`(`users_ID`) USING BTREE,
  INDEX `comments_ID_4`(`comments_ID`) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`news_ID`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`users_ID`) REFERENCES `users` (`users_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (50, '1000000002', '1000000003', '2018-09-12 23:05:12', '希望多发表这种新闻', 0, '已审核');
INSERT INTO `comments` VALUES (52, '1000000002', '1000000003', '2018-09-12 23:06:17', '不错，好评', 0, '已审核');
INSERT INTO `comments` VALUES (54, '1000000002', '1000000003', '2018-09-12 23:10:46', '你们都是哪里的人啊，这么有趣', 0, '已审核');
INSERT INTO `comments` VALUES (55, '1000000002', '1000000003', '2018-09-12 23:11:17', '小编不错，晚上加鸡腿', 0, '已审核');
INSERT INTO `comments` VALUES (64, '1000000002', '1000000001', '2018-09-13 09:41:54', '台独', 0, '未通过');
INSERT INTO `comments` VALUES (67, '1000000002', '1000000001', '2018-09-13 10:19:29', '好评', 0, '已审核');
INSERT INTO `comments` VALUES (68, '1000000002', '1000000001', '2018-09-13 10:19:46', '法轮功大法好', 0, '未通过');

-- ----------------------------
-- Table structure for comments_like
-- ----------------------------
DROP TABLE IF EXISTS `comments_like`;
CREATE TABLE `comments_like`  (
  `acts_ID` int(10) NOT NULL AUTO_INCREMENT,
  `comments_ID` int(10) NOT NULL,
  `news_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `users_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`acts_ID`) USING BTREE,
  INDEX `news_ID`(`news_ID`) USING BTREE,
  INDEX `comments_like_ibfk_1`(`comments_ID`) USING BTREE,
  INDEX `comments_like_ibfk_3`(`users_ID`) USING BTREE,
  CONSTRAINT `comments_like_ibfk_1` FOREIGN KEY (`comments_ID`) REFERENCES `comments` (`comments_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comments_like_ibfk_2` FOREIGN KEY (`news_ID`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comments_like_ibfk_3` FOREIGN KEY (`users_ID`) REFERENCES `users` (`users_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `likes_ID` int(10) NOT NULL AUTO_INCREMENT,
  `news_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `users_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `likes_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`likes_ID`) USING BTREE,
  INDEX `news_ID`(`news_ID`) USING BTREE,
  INDEX `likes_ibfk_2`(`users_ID`) USING BTREE,
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`news_ID`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`users_ID`) REFERENCES `users` (`users_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (45, '1000000002', '1000000003', '2018-09-12 22:18:30');
INSERT INTO `likes` VALUES (54, '1000000001', '1000000001', '2018-09-13 09:23:19');
INSERT INTO `likes` VALUES (57, '1000000002', '1000000001', '2018-09-13 10:05:33');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `news_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realse_time` datetime(0) NULL DEFAULT NULL,
  `news_type` int(3) NULL DEFAULT NULL,
  `news_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `likes` int(5) NULL DEFAULT NULL,
  `collecton_num` int(5) NULL DEFAULT NULL,
  `sharing_num` int(5) NULL DEFAULT NULL,
  `comment_num` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`news_ID`) USING BTREE,
  INDEX `news_ID`(`news_ID`) USING BTREE,
  INDEX `news_ID_2`(`news_ID`) USING BTREE,
  INDEX `news_ID_3`(`news_ID`) USING BTREE,
  INDEX `news_ID_4`(`news_ID`) USING BTREE,
  INDEX `news_ID_5`(`news_ID`) USING BTREE,
  INDEX `news_ID_6`(`news_ID`) USING BTREE,
  INDEX `news_ID_7`(`news_ID`) USING BTREE,
  INDEX `news_ID_8`(`news_ID`) USING BTREE,
  INDEX `news_ID_9`(`news_ID`) USING BTREE,
  INDEX `news_ID_10`(`news_ID`) USING BTREE,
  INDEX `news_ID_11`(`news_ID`) USING BTREE,
  INDEX `news_ID_12`(`news_ID`) USING BTREE,
  INDEX `news_ID_13`(`news_ID`) USING BTREE,
  INDEX `news_ID_14`(`news_ID`) USING BTREE,
  INDEX `news_ID_15`(`news_ID`) USING BTREE,
  INDEX `news_ID_16`(`news_ID`) USING BTREE,
  INDEX `news_ID_17`(`news_ID`) USING BTREE,
  INDEX `news_ID_18`(`news_ID`) USING BTREE,
  INDEX `news_ID_19`(`news_ID`) USING BTREE,
  INDEX `news_ID_20`(`news_ID`) USING BTREE,
  INDEX `news_ID_21`(`news_ID`) USING BTREE,
  INDEX `news_ID_22`(`news_ID`) USING BTREE,
  INDEX `news_ID_23`(`news_ID`) USING BTREE,
  INDEX `news_ID_24`(`news_ID`) USING BTREE,
  INDEX `news_ID_25`(`news_ID`) USING BTREE,
  INDEX `news_ID_26`(`news_ID`) USING BTREE,
  INDEX `news_ID_27`(`news_ID`) USING BTREE,
  INDEX `news_ID_28`(`news_ID`) USING BTREE,
  INDEX `news_ID_29`(`news_ID`) USING BTREE,
  INDEX `news_ID_30`(`news_ID`) USING BTREE,
  INDEX `news_ID_31`(`news_ID`) USING BTREE,
  INDEX `news_ID_32`(`news_ID`) USING BTREE,
  INDEX `news_ID_33`(`news_ID`) USING BTREE,
  INDEX `news_ID_34`(`news_ID`) USING BTREE,
  INDEX `news_ID_35`(`news_ID`) USING BTREE,
  INDEX `news_ID_36`(`news_ID`) USING BTREE,
  INDEX `news_ID_37`(`news_ID`) USING BTREE,
  INDEX `news_ID_38`(`news_ID`) USING BTREE,
  INDEX `news_ID_39`(`news_ID`) USING BTREE,
  INDEX `news_ID_40`(`news_ID`) USING BTREE,
  INDEX `news_ID_41`(`news_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1000000001', '小学期开始了', '2018-09-12 23:25:57', 2, 'http://192.168.43.139:8080/NewsManager2/news3.html', 3, 4, 0, 0);
INSERT INTO `news` VALUES ('1000000002', '谁是安卓开发大神', '2018-09-12 22:10:53', 2, 'http://192.168.43.139:8080/NewsManager2/news2.html', 5, 14, 0, 16);
INSERT INTO `news` VALUES ('1000000003', '个人信息安全有保障了', '2018-09-13 08:24:32', 3, 'http://www.bn45.com/a/sh01/563.html', 0, 0, 0, 0);
INSERT INTO `news` VALUES ('1000000004', '数字图像算法研究', '2018-09-13 08:26:17', 2, 'https://blog.csdn.net/Trent1985/article/details/82588186', 1, 1, 0, 0);
INSERT INTO `news` VALUES ('1000000005', '王越院士为了责任上讲台', '2018-09-13 08:27:56', 1, 'http://www.bit.edu.cn/xww/mtlg/158952.htm', 0, 0, 0, 0);
INSERT INTO `news` VALUES ('1000000006', '全民富二代的危害', '2018-09-13 08:28:41', 3, 'http://www.bn45.com/a/sh05/457.html', 0, 0, 0, 0);

-- ----------------------------
-- Table structure for sharings
-- ----------------------------
DROP TABLE IF EXISTS `sharings`;
CREATE TABLE `sharings`  (
  `sharings_ID` int(10) NOT NULL AUTO_INCREMENT,
  `news_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sharings_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`sharings_ID`) USING BTREE,
  INDEX `sharings_ibfk_2`(`news_ID`) USING BTREE,
  CONSTRAINT `sharings_ibfk_1` FOREIGN KEY (`news_ID`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sharings_ibfk_2` FOREIGN KEY (`news_ID`) REFERENCES `users` (`users_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2000000037 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `users_ID` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `E_mail` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`users_ID`) USING BTREE,
  INDEX `users_ID`(`users_ID`) USING BTREE,
  INDEX `users_ID_2`(`users_ID`) USING BTREE,
  INDEX `users_ID_3`(`users_ID`) USING BTREE,
  INDEX `users_ID_4`(`users_ID`) USING BTREE,
  INDEX `users_ID_5`(`users_ID`) USING BTREE,
  INDEX `users_ID_6`(`users_ID`) USING BTREE,
  INDEX `users_ID_7`(`users_ID`) USING BTREE,
  INDEX `users_ID_8`(`users_ID`) USING BTREE,
  INDEX `users_ID_9`(`users_ID`) USING BTREE,
  INDEX `users_ID_10`(`users_ID`) USING BTREE,
  INDEX `users_ID_11`(`users_ID`) USING BTREE,
  INDEX `users_ID_12`(`users_ID`) USING BTREE,
  INDEX `users_ID_13`(`users_ID`) USING BTREE,
  INDEX `users_ID_14`(`users_ID`) USING BTREE,
  INDEX `users_ID_15`(`users_ID`) USING BTREE,
  INDEX `users_ID_16`(`users_ID`) USING BTREE,
  INDEX `users_ID_17`(`users_ID`) USING BTREE,
  INDEX `users_ID_18`(`users_ID`) USING BTREE,
  INDEX `users_ID_19`(`users_ID`) USING BTREE,
  INDEX `users_ID_20`(`users_ID`) USING BTREE,
  INDEX `users_ID_21`(`users_ID`) USING BTREE,
  INDEX `users_ID_22`(`users_ID`) USING BTREE,
  INDEX `users_ID_23`(`users_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1000000001', '赵一', 'e10adc3949ba59abbe56e057f20f883e', '13126959311', '011@qq.com', '男');
INSERT INTO `users` VALUES ('1000000002', '钱二', 'e10adc3949ba59abbe56e057f20f883e', '12345678912', '032@qq.com', '男');
INSERT INTO `users` VALUES ('1000000003', '孙三', 'e10adc3949ba59abbe56e057f20f883e', '12345678912', '011@qq.com', '男');
INSERT INTO `users` VALUES ('1000000004', '李四', 'e10adc3949ba59abbe56e057f20f883e', '12345678915', '004@qq.com', '女');
INSERT INTO `users` VALUES ('1000000005', '周五', 'e10adc3949ba59abbe56e057f20f883e', '12345678916', '005@qq.com', '男');
INSERT INTO `users` VALUES ('1000000006', '吴六', 'e10adc3949ba59abbe56e057f20f883e', '12345678917', '006@qq.com', '女');
INSERT INTO `users` VALUES ('1000000007', '郑七', 'e10adc3949ba59abbe56e057f20f883e', '12345678918', '007@qq.com', '男');
INSERT INTO `users` VALUES ('1000000008', '王九', 'e10adc3949ba59abbe56e057f20f883e', '12345678919', '008@qq.com', '女');
INSERT INTO `users` VALUES ('1000000009', '齐十', 'e10adc3949ba59abbe56e057f20f883e', '12345678920', '009@qq.com', '男');
INSERT INTO `users` VALUES ('1000000010', '楚八', 'e10adc3949ba59abbe56e057f20f883e', '12345678921', '010@qq.com', '女');
INSERT INTO `users` VALUES ('1000000058', '顺丰速递', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('1007347128', '撒旦', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '女');
INSERT INTO `users` VALUES ('1007547128', '撒旦', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '男');
INSERT INTO `users` VALUES ('1073047128', '撒旦', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '男');
INSERT INTO `users` VALUES ('1077147128', '撒旦', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '男');
INSERT INTO `users` VALUES ('1213141511', '撒啊', 'e10adc3949ba59abbe56e057f20f883e', '', '', '女');
INSERT INTO `users` VALUES ('1300000011', '金卡', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '男');
INSERT INTO `users` VALUES ('1300000012', '太坊', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '男');
INSERT INTO `users` VALUES ('1300000013', '燃灯', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '女');
INSERT INTO `users` VALUES ('1300000014', '进度', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '男');
INSERT INTO `users` VALUES ('1310000000', '澄邈', 'e10adc3949ba59abbe56e057f20f883e', '12345678912', '012@qq.com', '男');
INSERT INTO `users` VALUES ('1310000001', '德泽', 'e10adc3949ba59abbe56e057f20f883e', '12345678925', '012@qq.com', '男');
INSERT INTO `users` VALUES ('1310000002', '海荣', 'e10adc3949ba59abbe56e057f20f883e', '12345678914', '003@qq.com', '女');
INSERT INTO `users` VALUES ('1310000003', '海逸', 'e10adc3949ba59abbe56e057f20f883e', '12345678915', '004@qq.com', '女');
INSERT INTO `users` VALUES ('1310000004', '海昌', 'e10adc3949ba59abbe56e057f20f883e', '12345678916', '005@qq.com', '男');
INSERT INTO `users` VALUES ('1310000005', '瀚文', 'e10adc3949ba59abbe56e057f20f883e', '12345678917', '006@qq.com', '女');
INSERT INTO `users` VALUES ('1310000006', '涵亮', 'e10adc3949ba59abbe56e057f20f883e', '12345678918', '007@qq.com', '男');
INSERT INTO `users` VALUES ('1310000007', '浩博', 'e10adc3949ba59abbe56e057f20f883e', '12345678919', '008@qq.com', '女');
INSERT INTO `users` VALUES ('1310000008', '浩初', 'e10adc3949ba59abbe56e057f20f883e', '12345678920', '009@qq.com', '男');
INSERT INTO `users` VALUES ('1310000009', '度发', 'e10adc3949ba59abbe56e057f20f883e', '12345678921', '010@qq.com', '女');
INSERT INTO `users` VALUES ('1310000010', '耳朵', 'e10adc3949ba59abbe56e057f20f883e', '12345678901', '059@qq.com', '女');

-- ----------------------------
-- View structure for comlike_infor
-- ----------------------------
DROP VIEW IF EXISTS `comlike_infor`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `comlike_infor` AS select `news`.`title` AS `新闻标题`,`news`.`realse_time` AS `新闻发布时间`,`users`.`name` AS `评论者`,`comments`.`comment_content` AS `评论内容`,`comments`.`comment_time` AS `评论时间`,`comments`.`likes` AS `评论点赞数` from ((`comments` join `news`) join `users`) where ((`comments`.`news_ID` = `news`.`news_ID`) and (`comments`.`users_ID` = `users`.`users_ID`) and (`comments`.`comment_type` = '已审核'));

-- ----------------------------
-- View structure for comments_infor
-- ----------------------------
DROP VIEW IF EXISTS `comments_infor`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `comments_infor` AS select `news`.`title` AS `新闻标题`,`news`.`realse_time` AS `新闻发布时间`,`users`.`users_ID` AS `评论者账号`,`users`.`name` AS `评论者`,`comments`.`comment_content` AS `评论内容`,`comments`.`comment_time` AS `评论时间` from ((`comments` join `news`) join `users`) where ((`comments`.`news_ID` = `news`.`news_ID`) and (`comments`.`users_ID` = `users`.`users_ID`) and (`comments`.`comment_type` = '未通过'));

-- ----------------------------
-- Procedure structure for admin_check
-- ----------------------------
DROP PROCEDURE IF EXISTS `admin_check`;
delimiter ;;
CREATE PROCEDURE `admin_check`(in num_begin varchar(10),in num_end varchar(10))
begin
delete from admin where admin.admin_ID<num_begin or admin.admin_ID>num_end;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
