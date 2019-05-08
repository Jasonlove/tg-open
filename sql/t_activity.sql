/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : open

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-05-08 10:43:02
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
  `foot_img` varchar(255) DEFAULT NULL COMMENT '尾部图片',
  `share_img` varchar(255) DEFAULT NULL COMMENT '分享也url地址',
  `tech_info` varchar(255) DEFAULT NULL COMMENT '推荐信息文字',
  `act_url` varchar(255) DEFAULT NULL COMMENT '生成url地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_transfer`;
CREATE TABLE `t_transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `transfer_no` varchar(64) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL COMMENT '发红包状态',
  `result_code` varchar(255) DEFAULT NULL,
  `result_message` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `merchant_id` varchar(64) DEFAULT NULL COMMENT '商户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
