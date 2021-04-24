/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : mall_product

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 24/04/2021 20:01:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_brand
-- ----------------------------
DROP TABLE IF EXISTS `product_brand`;
CREATE TABLE `product_brand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `first_letter` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '首字母',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `factory_status` int(1) DEFAULT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
  `show_status` int(1) DEFAULT NULL COMMENT '是否显示',
  `product_count` int(11) DEFAULT NULL COMMENT '产品数量',
  `product_comment_count` int(11) DEFAULT NULL COMMENT '产品评论数量',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '品牌logo',
  `big_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专区大图',
  `brand_story` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '品牌故事',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级分类编号：0->一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `level` int(1) DEFAULT NULL COMMENT '分类级别： 0->1级；1->2级',
  `product_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `product_unit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品单位',
  `nav_status` int(1) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(1) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关键字',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, 0, '服装', 0, 0, '件', 1, 1, 1, NULL, '服装', '服装分类');
INSERT INTO `product_category` VALUES (2, 0, '手机数码', 0, 0, '件', 1, 1, 1, NULL, '手机数码', '手机数码');
INSERT INTO `product_category` VALUES (3, 0, '家用电器', 0, 0, '件', 1, 1, 1, NULL, '家用电器', '家用电器');
INSERT INTO `product_category` VALUES (4, 0, '家具家装', 0, 0, '件', 1, 1, 1, NULL, '家具家装', '家具家装');
INSERT INTO `product_category` VALUES (5, 0, '汽车用品', 0, 0, '件', 1, 1, 1, NULL, '汽车用品', '汽车用品');
INSERT INTO `product_category` VALUES (7, 1, '外套', 1, 0, '件', 1, 1, 0, '', '外套', '外套');
INSERT INTO `product_category` VALUES (8, 1, 'T恤', 1, 0, '件', 1, 1, 0, '', 'T恤', 'T恤');
INSERT INTO `product_category` VALUES (9, 1, '休闲裤', 1, 0, '件', 1, 1, 0, NULL, '休闲裤', '休闲裤');
INSERT INTO `product_category` VALUES (10, 1, '牛仔裤', 1, 0, '件', 1, 1, 0, NULL, '牛仔裤', '牛仔裤');
INSERT INTO `product_category` VALUES (11, 1, '衬衫', 1, 0, '件', 1, 1, 0, NULL, '衬衫', '衬衫分类');
INSERT INTO `product_category` VALUES (12, 1, '男鞋', 1, 0, '双', 0, 0, 0, '', '男鞋', '男鞋');
INSERT INTO `product_category` VALUES (13, 2, '手机通讯', 1, 0, '件', 0, 0, 0, '', '手机通讯', '手机通讯');
INSERT INTO `product_category` VALUES (14, 2, '手机配件', 1, 0, '', 0, 0, 0, '', '手机配件', '手机配件');
INSERT INTO `product_category` VALUES (15, 2, '摄影摄像', 1, 0, '', 0, 0, 0, '', '摄影摄像', '摄影摄像');
INSERT INTO `product_category` VALUES (16, 2, '影音娱乐', 1, 0, '', 0, 0, 0, '', '影音娱乐', '影音娱乐');
INSERT INTO `product_category` VALUES (17, 2, '数码配件', 1, 0, '', 0, 0, 0, '', '数码配件', '数码配件');
INSERT INTO `product_category` VALUES (18, 2, '智能设备', 1, 0, '', 0, 0, 0, '', '智能设备', '智能设备');
INSERT INTO `product_category` VALUES (19, 3, '电视', 1, 0, '', 0, 0, 0, '', '电视', '电视');
INSERT INTO `product_category` VALUES (20, 3, '空调', 1, 0, '', 0, 0, 0, '', '空调', '空调');
INSERT INTO `product_category` VALUES (21, 3, '洗衣机', 1, 0, '', 0, 0, 0, '', '洗衣机', '洗衣机');
INSERT INTO `product_category` VALUES (22, 3, '冰箱', 1, 0, '', 0, 0, 0, '', '冰箱', '冰箱');
INSERT INTO `product_category` VALUES (23, 3, '厨卫大电', 1, 0, '', 0, 0, 0, '', '厨卫大电', '厨卫大电');
INSERT INTO `product_category` VALUES (24, 3, '厨房小电', 1, 0, '', 0, 0, 0, '', '厨房小电', '厨房小电');
INSERT INTO `product_category` VALUES (25, 3, '生活电器', 1, 0, '', 0, 0, 0, '', '生活电器', '生活电器');
INSERT INTO `product_category` VALUES (26, 3, '个护健康', 1, 0, '', 0, 0, 0, '', '个护健康', '个护健康');
INSERT INTO `product_category` VALUES (27, 4, '厨房卫浴', 1, 0, '', 0, 0, 0, '', '厨房卫浴', '厨房卫浴');
INSERT INTO `product_category` VALUES (28, 4, '灯饰照明', 1, 0, '', 0, 0, 0, '', '灯饰照明', '灯饰照明');
INSERT INTO `product_category` VALUES (29, 4, '五金工具', 1, 0, '', 0, 0, 0, '', '五金工具', '五金工具');
INSERT INTO `product_category` VALUES (30, 4, '卧室家具', 1, 0, '', 0, 0, 0, '', '卧室家具', '卧室家具');
INSERT INTO `product_category` VALUES (31, 4, '客厅家具', 1, 0, '', 0, 0, 0, '', '客厅家具', '客厅家具');
INSERT INTO `product_category` VALUES (32, 5, '全新整车', 1, 0, '', 0, 0, 0, '', '全新整车', '全新整车');
INSERT INTO `product_category` VALUES (33, 5, '车载电器', 1, 0, '', 0, 0, 0, '', '车载电器', '车载电器');
INSERT INTO `product_category` VALUES (34, 5, '维修保养', 1, 0, '', 0, 0, 0, '', '维修保养', '维修保养');
INSERT INTO `product_category` VALUES (35, 5, '汽车装饰', 1, 0, '', 0, 0, 0, '', '汽车装饰', '汽车装饰');

SET FOREIGN_KEY_CHECKS = 1;
