package com.boot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author yuansc
 * @date 2019/4/2 0002 下午 6:32
 */
@EnableDubboConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@EnableTransactionManagement
@ImportResource({"classpath:dubbo.xml"})
public class BopBootWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BopBootWebApplication.class, args);
    }
}
