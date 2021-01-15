package com.seaboxdata.model;

/**
 * 数据库的类型
 */
@Deprecated
public enum DBTypeEnum {
    NONE,
    MYSQL,
    HIVE,
    POSTGRESQL,
    SQLServer,
    ORACLE;

    public static DbSourceTypeEnum toDbSource(DBTypeEnum dbTypeEnum) {
        if (DBTypeEnum.MYSQL.equals(dbTypeEnum)) {
            return DbSourceTypeEnum.MYSQL;
        } else if (DBTypeEnum.HIVE.equals(dbTypeEnum)) {
            return DbSourceTypeEnum.HIVE2_MYSQL_METASTORE;
        } else if (DBTypeEnum.POSTGRESQL.equals(dbTypeEnum)) {
            return DbSourceTypeEnum.POSTGRESQL;
        } else if (DBTypeEnum.SQLServer.equals(dbTypeEnum)) {
            return DbSourceTypeEnum.MICROSOFT_SQL_SERVER;
        }else if (DBTypeEnum.ORACLE.equals(dbTypeEnum)) {
            return DbSourceTypeEnum.ORAClE;
        }
        return null;
    }
}
