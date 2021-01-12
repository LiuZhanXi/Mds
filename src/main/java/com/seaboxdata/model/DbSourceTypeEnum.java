package com.seaboxdata.model;

/**
 * ClassName:    DbSourceTypeEnum
 * Package:    com.seaboxdata.model
 * Description:
 * Datetime:    2021年01月07日   16:49
 * Author:     LiuZhanXi
 */
public enum DbSourceTypeEnum {
    HIVE2_MYSQL_METASTORE,
    POSTGRESQL,
    MYSQL,
    MPP,
    MYSQL51,
    MYSQL55,
    MYSQL56,
    MYSQL80,
    MICROSOFT_SQL_SERVER,
    GBASE_8A,
    ORAClE,
    ORAClE11,

    // only update by json
    MONGODB,
    ELASTICSEARCH,
    HBASE,
}