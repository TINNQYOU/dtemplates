package com.tinnkyou.common.config;

import com.tinnkyou.common.ApplicationContextHelper;
import com.tinnkyou.common.HttpInterceptor;
import com.tinnkyou.common.SpringExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {
    @Bean
    public SpringExceptionResolver springExceptionResolver(){
        return new SpringExceptionResolver();
    }
    @Bean
    public ApplicationContextHelper applicationContextHelper(){
        return new ApplicationContextHelper();
    }
}
