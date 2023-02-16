package com.cmrhyq.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1 style="color:white"></h1>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project CommonUtilsPackage
 * @docRoot com.cmrhyq.utils
 * @date 2023-02-16 1:13
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
@SpringBootApplication
public class CommonUtilsPackageApplication {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        SpringApplication.run(CommonUtilsPackageApplication.class, args);
        long endTime = System.currentTimeMillis();
        log.info("Program startup time consuming: {} ms", (endTime - beginTime));
    }
}
