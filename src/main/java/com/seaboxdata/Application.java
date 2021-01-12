package com.seaboxdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:    Applicaton
 * Package:    org.liuzhanxi
 * Description:
 * Datetime:    2020年10月13日   10:19
 * Author:     LiuZhanXi
 */
@SpringBootApplication(scanBasePackages = "com.seaboxdata")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
