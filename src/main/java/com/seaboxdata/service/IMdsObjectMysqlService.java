package com.seaboxdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seaboxdata.model.MdsObjectMysql;

/**
 * ClassName:    IMdsObjectMysqlService
 * Package:    com.seaboxdata.service
 * Description:
 * Datetime:    2021年01月12日   15:46
 * Author:     LiuZhanXi
 */
public interface IMdsObjectMysqlService extends IService<MdsObjectMysql> {
    /**
     * @return Boolean
     * @description mdsObject表由mongo > mysql
     * @author LiuZhanXi
     * @date 2021年01月12日 15:47
     */
    Boolean mdsObjectToMongo();
}
