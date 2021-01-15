package com.seaboxdata.mapper;

import com.seaboxdata.model.MdsObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:    MdsObjectMysqlMapper
 * Package:    com.seaboxdata.mapper
 * Description:
 * Datetime:    2021年01月12日   15:13
 * Author:     LiuZhanXi
 */
@Repository
public interface MdsObjectMapper extends MongoRepository<MdsObject, Long> {

    @Query(value = "{business_category_ids: {'$exists': true}}")
    List<MdsObject> findAllByBusinessCategoryIds();

    @Query(value = "{business_category_ids: {'$exists': false}}")
    List<MdsObject> findAllByBusinessCategoryNoIds();
}
