package com.zjc.bs.config;

import com.zjc.bs.config.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> list = new LinkedList<>();
//
//        list.add("/login.html");
//        list.add(("/bsuser/login"));
//        list.add(("/static/**"));
        String [] strings={"/bsuser/*","/accessory/*","/bigHouseWork/*","/courseDesign/*","/exam/*","/paper/*","/plan/*","/practice/*","/course/*","/estimate/*","/people/*"};
        registry.addInterceptor( loginInterceptor).addPathPatterns(strings).excludePathPatterns("/bsuser/login") ;
        super.addInterceptors(registry);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photos/**").addResourceLocations("file:" + "D:\\dev\\project\\BS\\src\\main\\resources\\static\\photos\\");
    }


}
