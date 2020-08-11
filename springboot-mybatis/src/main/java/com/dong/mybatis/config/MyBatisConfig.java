package com.dong.mybatis.config;


import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author dong
 * @date 2020/8/11 20:54
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                //开启驼峰命名法
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
