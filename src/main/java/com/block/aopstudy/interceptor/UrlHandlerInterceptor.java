package com.block.aopstudy.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangrongsong
 * @title: myHandlerInterceptor
 * @projectName aop-study
 * @description: 自定义拦截器
 * @date 2021/11/6 2:16 上午
 */
@Component
@Slf4j
public class UrlHandlerInterceptor implements HandlerInterceptor {
    /**
     * 调用目标方法前执行，拦截逻辑写这里
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.contains("/eat")){
            log.info("被拦截器拦截了,拦截路径：{}",uri);
            return true;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 目标方法执行完，视图渲染前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 视图渲染后调用，主要用于资源清理工作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
