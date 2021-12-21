package com.block.aopstudy.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author wangrongsong
 * @title: MyWebMvcConfig
 * @projectName aop-study
 * @description: 把拦截器添加WebMvcConfigurationSupport或实现WebMvcConfigurer，
 * 但是不能继承多个WebMvcConfigurationSupport，或者一个实现WebMvcConfigurer，一个继承WebMvcConfigurationSupport。
 * 这样会导致拦截器失效。
 * @date 2021/12/20 11:42 下午
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = MyWebMvcConfig.class )
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UrlHandlerInterceptor urlHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlHandlerInterceptor).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }



    /**
     * 处理中文乱码
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
        //添加中文转码
        converters.add(responseBodyConverter());
        //解决： 添加解决中文乱码后的配置之后，返回json数据直接报错 500：no convertter for return value of type
        //或这个：Could not find acceptable representation
        converters.add(messageConverter());

    }

    /**
     * 中文乱码处理
     * @return
     */
    @Bean
    public HttpMessageConverter<?> responseBodyConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    //2.1：解决中文乱码后，返回json时可能会出现No converter found for return value of type: xxxx
    //或这个：Could not find acceptable representation
    //解决此问题如下
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    //2.2：解决No converter found for return value of type: xxxx
    @Bean
    public MappingJackson2HttpMessageConverter messageConverter(){
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(getObjectMapper());
        //等同于上面2行
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(getObjectMapper());
        return converter;
    }
}
