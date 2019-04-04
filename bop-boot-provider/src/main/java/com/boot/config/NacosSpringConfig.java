package com.boot.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.sijibao.nacos.spring.context.annotation.EnableNacosExConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yuansc
 * @date 2019/3/8 0008 下午 3:58
 */

@Configuration
@EnableNacosExConfig
@NacosPropertySource(dataId = "bop_service",groupId ="MLS_bop" ,autoRefreshed = true)
public class NacosSpringConfig {
}
