/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : product

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 24/05/2021 17:31:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键（自增ID）',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `web` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '品牌网站',
  `sort` int(11) DEFAULT NULL COMMENT '品牌序列',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '品牌状态：1- 可用， 0为不可用 ',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `first_word` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌首字母',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品品牌\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, '万和', NULL, NULL, 1, NULL, '2021-05-16 13:56:29', 'W');
INSERT INTO `brand` VALUES (2, '三星', NULL, NULL, 1, NULL, '2021-05-16 13:50:23', 'S');
INSERT INTO `brand` VALUES (3, '华为', NULL, NULL, 1, NULL, '2021-05-16 13:50:34', 'H');
INSERT INTO `brand` VALUES (4, '格力', NULL, NULL, 1, NULL, '2021-05-16 13:50:45', 'G');
INSERT INTO `brand` VALUES (5, '方太', NULL, NULL, 1, NULL, '2021-05-16 13:50:55', 'F');
INSERT INTO `brand` VALUES (6, '小米', NULL, NULL, 1, NULL, '2021-05-16 13:51:10', 'M');
INSERT INTO `brand` VALUES (7, 'OPPO', NULL, NULL, 1, NULL, '2021-05-16 13:51:23', 'O');
INSERT INTO `brand` VALUES (8, '七匹狼', NULL, NULL, 1, NULL, '2021-05-16 13:51:36', 'S');
INSERT INTO `brand` VALUES (9, '海澜之家', NULL, NULL, 1, NULL, '2021-05-16 13:51:45', 'H');
INSERT INTO `brand` VALUES (10, '苹果', NULL, NULL, 1, NULL, '2021-05-16 13:51:53', 'A');
INSERT INTO `brand` VALUES (11, 'NIKE', NULL, NULL, 1, NULL, '2021-05-16 13:52:05', 'N');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键(自增ID)',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '上级分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `product_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `product_unit` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品单位',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '状态：0->不显示；1->显示',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '描述',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 0, '服装', 0, '件', 1, 1, NULL, '服装分类', NULL);
INSERT INTO `category` VALUES (2, 0, '手机数码', 0, '件', 1, 1, NULL, '手机数码', NULL);
INSERT INTO `category` VALUES (3, 0, '家用电器', 0, '件', 1, 1, NULL, '家用电器', NULL);
INSERT INTO `category` VALUES (4, 0, '家具家装', 0, '件', 1, 1, NULL, '家具家装', NULL);
INSERT INTO `category` VALUES (5, 0, '汽车用品', 0, '件', 1, 1, NULL, '汽车用品', NULL);
INSERT INTO `category` VALUES (7, 1, '外套', 0, '件', 1, 0, '', '外套', NULL);
INSERT INTO `category` VALUES (8, 1, 'T恤', 0, '件', 1, 0, '', 'T恤', NULL);
INSERT INTO `category` VALUES (9, 1, '休闲裤', 0, '件', 1, 0, NULL, '休闲裤', NULL);
INSERT INTO `category` VALUES (10, 1, '牛仔裤', 0, '件', 1, 0, NULL, '牛仔裤', NULL);
INSERT INTO `category` VALUES (11, 1, '衬衫', 0, '件', 1, 0, NULL, '衬衫分类', NULL);
INSERT INTO `category` VALUES (19, 2, '手机通讯', 0, '件', 1, 0, '', '手机通讯', NULL);
INSERT INTO `category` VALUES (29, 1, '男鞋', 0, '双', 1, 0, '', '男鞋', NULL);
INSERT INTO `category` VALUES (30, 2, '手机配件', 0, '', 1, 0, '', '手机配件', NULL);
INSERT INTO `category` VALUES (31, 2, '摄影摄像', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (32, 2, '影音娱乐', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (33, 2, '数码配件', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (34, 2, '智能设备', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (35, 3, '电视', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (36, 3, '空调', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (37, 3, '洗衣机', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (38, 3, '冰箱', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (39, 3, '厨卫大电', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (40, 3, '厨房小电', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (41, 3, '生活电器', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (42, 3, '个护健康', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (43, 4, '厨房卫浴', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (44, 4, '灯饰照明', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (45, 4, '五金工具', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (46, 4, '卧室家具', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (47, 4, '客厅家具', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (48, 5, '全新整车', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (49, 5, '车载电器', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (50, 5, '维修保养', 0, '', 1, 0, '', '', NULL);
INSERT INTO `category` VALUES (51, 5, '汽车装饰', 0, '', 1, 0, '', '', NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键(自增ID)',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID(外键)',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类名称',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌ID(外键)',
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '品牌名称',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片',
  `price` decimal(12, 2) DEFAULT NULL COMMENT '价格',
  `unit` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '描述',
  `sort` int(20) DEFAULT NULL COMMENT '排序',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '状态：1-上架，0-下架',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品基础信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_property_value
-- ----------------------------
DROP TABLE IF EXISTS `product_property_value`;
CREATE TABLE `product_property_value`  (
  `id` bigint(20) NOT NULL COMMENT '自增ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `property` bigint(20) DEFAULT NULL COMMENT '属性ID',
  `value` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品属性值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '商品类型',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '属性名称',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品属性表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `sku_stock`;
CREATE TABLE `sku_stock`  (
  `id` bigint(20) NOT NULL COMMENT '主键（自增ID）',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `sku_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'SKU编码',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '价格',
  `stock` int(11) DEFAULT 0 COMMENT '库存',
  `low_stock` int(11) DEFAULT NULL COMMENT '预警库存',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `sp_data` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品属性组合，json格式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品SKU表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品类型名称',
  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '服装-T恤', NULL);
INSERT INTO `type` VALUES (2, '服装-裤装', NULL);
INSERT INTO `type` VALUES (3, '手机数码-手机通讯', NULL);
INSERT INTO `type` VALUES (4, '配件', NULL);
INSERT INTO `type` VALUES (5, '居家', NULL);
INSERT INTO `type` VALUES (6, '洗护', NULL);
INSERT INTO `type` VALUES (7, '服装-鞋帽', NULL);

SET FOREIGN_KEY_CHECKS = 1;
