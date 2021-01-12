package com.seaboxdata.mapper;

import com.seaboxdata.model.MdsObjectMysql;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName:    MdsObjectMysqlMapper
 * Package:    com.seaboxdata.mapper
 * Description:
 * Datetime:    2021年01月12日   15:13
 * Author:     LiuZhanXi
 */
@Repository
public interface MdsObjectMysqlMapper extends MongoRepository<MdsObjectMysql, Long> {

}
