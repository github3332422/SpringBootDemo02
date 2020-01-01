/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 123.56.25.127:3306
 Source Schema         : db_luckymoney

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 01/01/2020 16:45:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (10);

-- ----------------------------
-- Table structure for luckymoney
-- ----------------------------
DROP TABLE IF EXISTS `luckymoney`;
CREATE TABLE `luckymoney`  (
  `id` int(11) NOT NULL,
  `consumer` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `money` decimal(19, 2) NULL DEFAULT NULL,
  `producer` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of luckymoney
-- ----------------------------
INSERT INTO `luckymoney` VALUES (1, 'zq', 1000.00, 'producer');
INSERT INTO `luckymoney` VALUES (2, '??', 100.00, '??');
INSERT INTO `luckymoney` VALUES (4, 'zw', 100.00, 'zq');
INSERT INTO `luckymoney` VALUES (5, 'zq', 520.00, NULL);
INSERT INTO `luckymoney` VALUES (6, 'zq', 1314.00, NULL);
INSERT INTO `luckymoney` VALUES (7, 'zq', 123.00, 'zw');
INSERT INTO `luckymoney` VALUES (8, 'zq', 123.00, 'zw');
INSERT INTO `luckymoney` VALUES (9, 'zq', NULL, 'zw');

SET FOREIGN_KEY_CHECKS = 1;
