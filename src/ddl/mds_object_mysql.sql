/*
 Navicat Premium Data Transfer

 Source Server         : localhost mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : mds_server_deploy

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 15/01/2021 15:58:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mds_object_mysql
-- ----------------------------
DROP TABLE IF EXISTS `mds_object_mysql`;
CREATE TABLE `mds_object_mysql`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `chinese_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表中文名',
  `tech_linkman_id` bigint(20) NULL DEFAULT NULL COMMENT '技术负责人id',
  `busi_linkman_id` bigint(20) NULL DEFAULT NULL COMMENT '业务负责人id',
  `market_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '集市名字',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `data_framework_level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据架构层次',
  `technology_category_id` bigint(20) NULL DEFAULT NULL COMMENT '技术类目id',
  `business_category_ids` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '业务类目ID列表 使用,隔开',
  `mds_object_type_enum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '元数据类型',
  `storage_size` bigint(20) NULL DEFAULT NULL COMMENT '存储量',
  `rows` bigint(50) NULL DEFAULT NULL COMMENT '记录数',
  `data_size` bigint(50) NULL DEFAULT NULL COMMENT '数据大小',
  `index_size` bigint(50) NULL DEFAULT NULL COMMENT '索引大小',
  `storage_type_enum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存储方式',
  `create_time` datetime(3) NULL DEFAULT NULL COMMENT '元数据库创建时间',
  `update_time` datetime(3) NULL DEFAULT NULL COMMENT '元数据最后更新时间',
  `ddl_last_update_date` datetime(3) NULL DEFAULT NULL COMMENT 'ddl最后更新时间',
  `last_change_date` datetime(3) NULL DEFAULT NULL COMMENT '数据最后变更时间由updateTime代替',
  `last_query_date` datetime(3) NULL DEFAULT NULL COMMENT '数据最后查询时间',
  `is_tmp_table` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否临时表',
  `is_copy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表是否是拷贝表',
  `is_desc_completion` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '元数据描述是否完整',
  `data_base_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名',
  `creator` bigint(20) NULL DEFAULT NULL COMMENT '记录创建人',
  `modifier` bigint(20) NULL DEFAULT NULL COMMENT '记录修改人',
  `create_tm` datetime(3) NULL DEFAULT NULL COMMENT '记录创建时间',
  `modify_tm` datetime(3) NULL DEFAULT NULL COMMENT '记录修改时间',
  `version_id` bigint(20) NULL DEFAULT NULL COMMENT '版本id',
  `inc_rows` bigint(20) NULL DEFAULT NULL COMMENT '增量记录数',
  `inc_stor_size` bigint(20) NULL DEFAULT NULL COMMENT '增量数据量',
  `avail_time` datetime(3) NULL DEFAULT NULL COMMENT '数据有效日期',
  `src_tbl_nature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '源表性质',
  `src_tbl_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '源表注释',
  `cls_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清理要求和周期',
  `is_inc_update_avaliable` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可提供增量',
  `tbl_rela_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表关联信息',
  `is_phys_del` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有物理删除',
  `ddl` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'table create script',
  `is_partition_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否分区表',
  `db_source_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源类型',
  `columns_json` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段备注信息',
  `as_input` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为收动录入的',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
