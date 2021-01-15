package com.seaboxdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seaboxdata.model.MdsObjectMysql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName:    MdsObjectMysqlMapper
 * Package:    com.seaboxdata.mapper
 * Description:
 * Datetime:    2021年01月14日   16:57
 * Author:     LiuZhanXi
 */
@Mapper
public interface MdsObjectMysqlMapper extends BaseMapper<MdsObjectMysql> {

    @Update("truncate table mds_object_mysql")
    void deleteMdsObjectMysql();
}
