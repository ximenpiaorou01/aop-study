//package com.block.aopstudy.interceptor;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.nio.charset.Charset;
//import java.util.List;
//
///**
// * @author wangrongsong
// * @title: WebAppConfig
// * @projectName aop-study
// * @description: TODO
// * @date 2021/12/20 10:10 下午
// */
//@Configuration
//public class WebAppConfig extends WebMvcConfigurationSupport {
//
//
//    /**
//     * 处理中文乱码
//     * @param converters
//     */
//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        //添加中文转码
//        converters.add(responseBodyConverter());
//        //解决： 添加解决中文乱码后的配置之后，返回json数据直接报错 500：no convertter for return value of type
//        //或这个：Could not find acceptable representation
//        converters.add(messageConverter());
//
//    }
//
//    /**
//     * 中文乱码处理
//     * @return
//     */
//    @Bean
//    public HttpMessageConverter<?> responseBodyConverter(){
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return converter;
//    }
//
//    //2.1：解决中文乱码后，返回json时可能会出现No converter found for return value of type: xxxx
//    //或这个：Could not find acceptable representation
//    //解决此问题如下
//    public ObjectMapper getObjectMapper(){
//        return new ObjectMapper();
//    }
//
//    //2.2：解决No converter found for return value of type: xxxx
//    @Bean
//    public MappingJackson2HttpMessageConverter messageConverter(){
////        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
////        converter.setObjectMapper(getObjectMapper());
//        //等同于上面2行
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(getObjectMapper());
//        return converter;
//    }
//}
