package com.seaboxdata.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:    IMdsObjectMysqlController
 * Package:    com.seaboxdata.controller
 * Description:
 * Datetime:    2021年01月12日   16:00
 * Author:     LiuZhanXi
 */
public interface IMdsObjectMysqlController {

    @GetMapping("/mdsObjectToMysql")
    Boolean mdsObjectToMysql();
}
