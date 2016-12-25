/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50156
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50156
File Encoding         : 65001

Date: 2016-12-25 18:56:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'aaaaaaaaaaadd', 'dd');
INSERT INTO `user` VALUES ('6', 'wwwwwwwwwwww', 'ww');
INSERT INTO `user` VALUES ('7', 'ssw', 'sss');
