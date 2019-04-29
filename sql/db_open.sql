/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : open

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-04-29 19:18:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '活动名称',
  `start_time` datetime DEFAULT NULL COMMENT '活动时间',
  `end_time` datetime DEFAULT NULL COMMENT '截止时间',
  `url` varchar(255) DEFAULT NULL COMMENT '活动页面地址',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '报名金额',
  `share_amount` decimal(10,2) DEFAULT NULL COMMENT '分享金额',
  `join_count` int(8) DEFAULT '0' COMMENT '活动参与个数',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('1', '测试数据', '2019-04-29 12:29:16', '2019-04-29 12:29:19', '/open/act', '10.00', '0.60', '0', '2019-04-26 15:02:06');
INSERT INTO `t_activity` VALUES ('2', '测试数据2', '2019-04-29 12:53:19', '2019-04-29 12:53:23', null, '10.00', '0.10', '0', '2019-04-29 12:53:32');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `act_id` int(11) DEFAULT NULL COMMENT '活动id',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `iphone` varchar(32) DEFAULT NULL,
  `openId` varchar(64) DEFAULT NULL COMMENT '公众号用户id',
  `amount` decimal(10,2) DEFAULT NULL,
  `trade_no` varchar(64) DEFAULT NULL COMMENT '支付流水号',
  `out_trade_no` varchar(64) DEFAULT NULL COMMENT '微信',
  `status` varchar(32) DEFAULT NULL COMMENT 'success,',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `nickname` varchar(64) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `act_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
