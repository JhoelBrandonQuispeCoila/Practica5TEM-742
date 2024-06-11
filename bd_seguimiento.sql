/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80037
 Source Host           : localhost:3306
 Source Schema         : bd_seguimiento

 Target Server Type    : MySQL
 Target Server Version : 80037
 File Encoding         : 65001

 Date: 11/06/2024 17:39:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for estudiantes
-- ----------------------------
DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE `estudiantes`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellidos` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fechaNacimiento` date NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of estudiantes
-- ----------------------------
BEGIN;
INSERT INTO `estudiantes` VALUES (1, 'Juan', 'Pérez', 'juan.perez@mail.com', '1990-01-15'), (2, 'María', 'García', 'maria.garcia@mail.com', '1985-05-23'), (3, 'Jhoel', 'Quispe', 'jhoel.quispe@mail.com', '2003-04-25'), (4, 'Ana', 'Martínez', 'ana.martinez@mail.com', '1988-12-12'), (5, 'Luis', 'Hernández', 'luis.hernandez@mail.com', '1995-09-10');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
