//package com.block.aopstudy.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * @author wangrongsong
// * @title: UserIntercepter
// * @projectName aop-study
// * @description: 或者实现WebMvcConfigure类
// * 拦截器主要方法：
// * configurePathMatch：配置路由请求规则
// * configureContentNegotiation：内容协商配置
// * configureAsyncSupport
// * configureDefaultServletHandling：默认静态资源处理器
// * addFormatters：注册自定义转化器
// * addInterceptors：拦截器配置
// * addResourceHandlers：资源处理
// * addCorsMappings：CORS配置
// * addViewControllers：视图跳转控制器
// * configureViewResolvers：配置视图解析
// * addArgumentResolvers：添加自定义方法参数处理器
// * addReturnValueHandlers：添加自定义返回结果处理器
// * configureMessageConverters：配置消息转换器。重载会覆盖默认注册的HttpMessageConverter
// * extendMessageConverters：配置消息转换器。仅添加一个自定义的HttpMessageConverter.
// * configureHandlerExceptionResolvers：配置异常转换器
// * extendHandlerExceptionResolvers：添加异常转化器
// * getValidator
// * getMessageCodesResolver
// * @date 2021/11/6 1:59 上午
// */
//@Configuration
//public class UserIntercepter extends WebMvcConfigurationSupport {
//
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        //注册我们自定义的拦截器，我这里是UrlInHandlerInterceptor
//        //该拦截器会对路径/eat/**拦截
//        registry.addInterceptor(new UrlHandlerInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//
//    /**
//     * 添加一些静态资源文件，比如css,js,img,html等
//     * @param registry
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
//    }
//
//    /**
//     * 跨域
//     */
////    @Override
////    protected void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedOrigins("*")
////                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
////                .allowCredentials(true)
////                .allowedHeaders("*")
////                .maxAge(3600);
////    }
//}
