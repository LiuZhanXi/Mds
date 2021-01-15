package com.seaboxdata.controller;

import com.seaboxdata.service.IMdsObjectMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:    MdsObjectMysqlController
 * Package:    com.seaboxdata.controller
 * Description:
 * Datetime:    2021年01月12日   16:01
 * Author:     LiuZhanXi
 */
@RestController
public class MdsObjectMysqlController implements IMdsObjectMysqlController {

    private IMdsObjectMysqlService mdsObjectMysqlService;

    @Autowired
    public MdsObjectMysqlController(IMdsObjectMysqlService mdsObjectMysqlService) {
        this.mdsObjectMysqlService = mdsObjectMysqlService;
    }

    @Override
    public Boolean mdsObjectToMysql() {
        return mdsObjectMysqlService.mdsObjectToMongo();
    }
}
