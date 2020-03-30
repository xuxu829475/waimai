/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : waimai

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-03-30 22:13:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `goods_num` int(11) DEFAULT '0' COMMENT '商品数量',
  `is_show` char(1) DEFAULT NULL COMMENT '是否显示',
  `is_menu` char(1) DEFAULT NULL COMMENT '是否导航',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1217 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品类目';

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='行业类目';

-- ----------------------------
-- Records of industry
-- ----------------------------

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------

-- ----------------------------
-- Table structure for pec
-- ----------------------------
DROP TABLE IF EXISTS `pec`;
CREATE TABLE `pec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '规格选项',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '门店ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='规格';

-- ----------------------------
-- Records of pec
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` bigint(20) NOT NULL,
  `industry_id` bigint(20) DEFAULT NULL COMMENT '所属行业ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '所属组织ID',
  `name` varchar(100) DEFAULT NULL COMMENT '门店名字',
  `image` varchar(1000) DEFAULT NULL COMMENT '门店图片',
  `addr` varchar(100) DEFAULT NULL COMMENT '门店地址',
  `time` varchar(100) DEFAULT NULL COMMENT '门店营业时间',
  `phone` varchar(15) DEFAULT NULL COMMENT '门店电话',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '商品名',
  `category_id` bigint(20) DEFAULT NULL COMMENT '类目ID',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '门店ID',
  `image` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `sale_num` int(11) DEFAULT NULL COMMENT '销量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '价格',
  `spec` varchar(255) DEFAULT NULL COMMENT '规格',
  `status` tinyint(1) DEFAULT NULL COMMENT '商品状态 1-正常，2-下架，3-删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL COMMENT '掌柜描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of sku
-- ----------------------------
