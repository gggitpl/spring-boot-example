/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.15
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : 192.168.0.15:3306
 Source Schema         : wulan_db

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 13/12/2018 17:17:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `enable` tinyint(255) NOT NULL DEFAULT 1,
  `addTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `alterTime` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'root', '{bcrypt}$2a$10$cr9LHWynfBvmF7OFvY8TUe5RyIaePRDTSjF2PTI1a/MHwy66ad1Ra', 1, '2018-12-13 06:21:11', NULL);

SET FOREIGN_KEY_CHECKS = 1;
