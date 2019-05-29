/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : open

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-05-29 17:19:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '活动名称',
  `merchant` varchar(255) DEFAULT NULL COMMENT '商家名称',
  `start_time` datetime DEFAULT NULL COMMENT '活动时间',
  `end_time` datetime DEFAULT NULL COMMENT '截止时间',
  `amount` double(10,2) DEFAULT NULL COMMENT '报名金额',
  `share_amount` double(10,2) DEFAULT NULL COMMENT '分享金额',
  `limit_count` int(8) DEFAULT '0' COMMENT '活动限制名额',
  `join_count` int(8) DEFAULT '0' COMMENT '活动参与个数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `first_img` varchar(255) DEFAULT NULL COMMENT '首部图片',
  `info_img` varchar(255) DEFAULT NULL COMMENT '商品信息',
  `foot_img` varchar(255) DEFAULT NULL COMMENT '保留字段，尾部页面',
  `share_img` varchar(255) DEFAULT NULL COMMENT '分享也url地址',
  `tech_info` varchar(255) DEFAULT NULL COMMENT '推荐信息文字',
  `act_url` varchar(255) DEFAULT NULL COMMENT '生成url地址',
  `music` varchar(255) DEFAULT NULL COMMENT '音乐',
  `call_qr` varchar(255) DEFAULT NULL COMMENT '客服二维码',
  `share_title` varchar(255) DEFAULT NULL COMMENT '分享标题',
  `share_desc` varchar(255) DEFAULT NULL COMMENT '分享描述',
  `share_small_img` varchar(255) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('1', '测试活动', '瑞辛咖啡', '2019-05-08 13:58:27', '2019-05-11 13:58:29', '100.00', '100.00', '1', '3', '2019-05-08 13:59:05', '/component/1558191008690.jpg', '/component/1558191014826.jpg', null, '/component/1558191019287.jpg', '测试文字说明', 'http://xinghui.natapp1.cc/open/authorize?actId=1', '', '', '测试分享标题', '测试分享描述', '/component/1558190313997.png', null);
INSERT INTO `t_activity` VALUES ('2', '测试活动2', '瑞辛咖啡', '2019-05-08 14:03:22', '2019-05-11 15:04:26', '1.00', '1.00', '1', '1', '2019-05-08 14:03:49', '/component/1557299013733.jpg', '/component/1557299014477.jpg', null, '/component/1557299015482.jpg', '', 'http://xinghui.natapp1.cc/open/authorize?actId=2', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL COMMENT '用户名密码',
  `password` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '登陆时间',
  `role_id` int(4) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'jason', '123456', '2019-05-20 13:50:24', '2019-05-20 13:50:32', '1');
INSERT INTO `t_admin` VALUES ('2', 'open', '123456', '2019-05-28 21:32:17', null, '1');

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth` (
  `id` int(11) NOT NULL,
  `type` varchar(4) DEFAULT NULL COMMENT '1.活动，2.订单，3.转账，4.联系人',
  `name` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '项目路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth
-- ----------------------------
INSERT INTO `t_auth` VALUES ('1000', '1', '活动列表', '活动权限', '/openAdmin/activity');
INSERT INTO `t_auth` VALUES ('2000', '2', '订单列表', '订单权限', '/openAdmin/order');
INSERT INTO `t_auth` VALUES ('3000', '3', '转账列表', '转账权限', '/openAdmin/transfer');
INSERT INTO `t_auth` VALUES ('4000', '4', '联系人列表', '联系人权限', '/openAdmin/contact');
INSERT INTO `t_auth` VALUES ('5000', '5', '管理员', '管理员权限', '/openAdmin/admin');

-- ----------------------------
-- Table structure for t_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_contact`;
CREATE TABLE `t_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系信息',
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号',
  `company` varchar(64) DEFAULT NULL COMMENT '公司名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contact
-- ----------------------------
INSERT INTO `t_contact` VALUES ('1', '1', 'Jason', '18630903713', '啦啦啦啦啦啦', '2019-05-09 13:43:28');
INSERT INTO `t_contact` VALUES ('2', '1', '小佳佳', '18630903713', '北京公司', '2019-05-09 14:22:54');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `act_id` int(11) DEFAULT NULL COMMENT '活动id',
  `user_id` int(11) DEFAULT NULL,
  `act_name` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `merchant` varchar(255) DEFAULT NULL COMMENT '商家名称',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `iphone` varchar(32) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `trade_no` varchar(64) DEFAULT NULL COMMENT '支付流水号',
  `out_trade_no` varchar(64) DEFAULT NULL COMMENT '微信',
  `status` varchar(32) DEFAULT NULL COMMENT 'success,',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `merchant_id` varchar(64) DEFAULT NULL COMMENT '收款商户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '1', '测试活动', '瑞辛咖啡', '香蕉', '18630903713', '1.00', 'O20190508154543413', 'O20190508154543413', 'success', '2019-05-08 15:45:43', '2019-05-08 16:24:56', null);
INSERT INTO `t_order` VALUES ('2', '1', '1', '测试活动', '瑞辛咖啡', '香蕉', '18630903713', '1.00', 'O20190508154546525', 'O20190508154543413', 'success', '2019-05-08 15:45:46', '2019-05-08 16:24:59', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `desc` varchar(64) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '超级管理员');
INSERT INTO `t_role` VALUES ('2', '普通商户', '普通商户');

-- ----------------------------
-- Table structure for t_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_role_auth`;
CREATE TABLE `t_role_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `auth_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_auth
-- ----------------------------
INSERT INTO `t_role_auth` VALUES ('1', '1', '1000');
INSERT INTO `t_role_auth` VALUES ('2', '1', '2000');
INSERT INTO `t_role_auth` VALUES ('3', '1', '3000');
INSERT INTO `t_role_auth` VALUES ('4', '1', '4000');
INSERT INTO `t_role_auth` VALUES ('5', '2', '1000');
INSERT INTO `t_role_auth` VALUES ('6', '1', '5000');

-- ----------------------------
-- Table structure for t_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_transfer`;
CREATE TABLE `t_transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '收到红包用户id',
  `act_id` int(10) NOT NULL COMMENT '活动id',
  `transfer_no` varchar(64) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL COMMENT '发红包状态',
  `result_code` varchar(255) DEFAULT NULL,
  `result_message` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `merchant_id` varchar(64) DEFAULT NULL COMMENT '商户id',
  `order_uid` int(11) DEFAULT NULL COMMENT '支付订单用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_transfer
-- ----------------------------
INSERT INTO `t_transfer` VALUES ('1', '1', '1', 'T1308301823018203810', '0.01', 'pending', '', null, '2019-05-09 10:34:06', null, '4');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `nickname` varchar(64) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL COMMENT 'AccessToken',
  `act_id` int(11) DEFAULT NULL,
  `share_user_id` int(11) DEFAULT NULL COMMENT '活动分享人id',
  `share_income` double(10,2) DEFAULT '0.00' COMMENT '收益总金额',
  `share_count` int(10) DEFAULT '0' COMMENT '分享收益人数',
  PRIMARY KEY (`id`),
  KEY `openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'o-Kqa1BNqdwvmFOKDRU7k1SuHvFo', 'Jason', 'http://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELZgkbEzPLolXa8dly3ok0hjxty8EppVzFCyMvIIF2wxzAAmp1e2YkFJeyUW0xlfoPDkqU4laluLQ/132', '21_o5pS7XKFYjQXicwoBxNOE-oroN2eJQt3tMCaVyHIkp4bwqdrbo2oGfubcqPvbHp-awEcDh8StUcp14Ieza60YgqE2i4vFXsr5I4usQKV-EY', '1', null, '0.00', '0');
INSERT INTO `t_user` VALUES ('2', 'o-Kqa1BNqdwvmFOKDRU7k1SuHvFo', 'Jason', 'http://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELZgkbEzPLolXa8dly3ok0hjxty8EppVzFCyMvIIF2wxzAAmp1e2YkFJeyUW0xlfoPDkqU4laluLQ/132', '21_JmDqiwFq5ZRfPLprUuAmRxf-_N8igK-vUPFx6ywU4mFQScgTvgoCI1tx3hCcDS36lPNfm_MkV6IjJlWErvMgFhvLFCR9WlL0L9emtKWao8E', '2', null, '0.00', '0');
INSERT INTO `t_user` VALUES ('3', 'o-Kqa1KX3n2XRdOaWIx7GXjN5D_Y', '小泽、', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTILkZb3D5AyQsEyKqiaLnCykQzKhUlQbSRtX3h2rg3TXBEPRd3ktTCeY21LwicQmkESaft8IkUqB1OA/132', '21_2H-GHxXD5cuAGI3p33fr5AbobzNu9zivBnjwy1M-Zzx8QWJr2_BTE90ebL7OPn0REz_yREK5MKhs5LTxWlo4PqhNCiOI5wiZGMx8qlQ9sdk', '1', null, '0.00', '0');
INSERT INTO `t_user` VALUES ('4', 'o-Kqa1EVKqYKjStr_AhR-Jn_Ze90', '鱼莫', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIvShmlkY8IPnA1DgItqjNfEzZHt6k09Hlian4MoHBtXZOCU940GU6WTiayS15aoaSibEcpRvY0N187g/132', '21_WmEHRoVZnLm9s4j5Y372XXOyf2wo4WBMc-8DsAY_7fYzz--gZZq6YPkULCZ4G3St2GFipRMqPZzThYyUSuzs-cRLH9ZId1Vi7dBOa-e9A4k', '1', null, '0.00', '0');
