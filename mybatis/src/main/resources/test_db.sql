/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.15
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : 192.168.0.15:3306
 Source Schema         : test_db

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 14/12/2018 15:29:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES (1, '一班');
INSERT INTO `t_clazz` VALUES (2, '二班');
INSERT INTO `t_clazz` VALUES (3, '三班');

-- ----------------------------
-- Table structure for t_clazz_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz_teacher`;
CREATE TABLE `t_clazz_teacher`  (
  `id` int(11) NOT NULL,
  `clazz_id` int(11) NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_clazz_teacher
-- ----------------------------
INSERT INTO `t_clazz_teacher` VALUES (1, 1, 1);
INSERT INTO `t_clazz_teacher` VALUES (2, 1, 2);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `clazz_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '张三', 1);

-- ----------------------------
-- Table structure for t_student_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_student_teacher`;
CREATE TABLE `t_student_teacher`  (
  `id` int(11) NOT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  `teacher_id` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student_teacher
-- ----------------------------
INSERT INTO `t_student_teacher` VALUES (1, 1, 1);
INSERT INTO `t_student_teacher` VALUES (2, 1, 2);
INSERT INTO `t_student_teacher` VALUES (3, 1, 3);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, '李老师');
INSERT INTO `t_teacher` VALUES (2, '王老师');
INSERT INTO `t_teacher` VALUES (3, '东东老师');

SET FOREIGN_KEY_CHECKS = 1;
