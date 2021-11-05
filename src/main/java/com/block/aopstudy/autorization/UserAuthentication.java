package com.block.aopstudy.autorization;

import com.block.aopstudy.annotation.Auth;
import com.block.aopstudy.enums.CommonEnum;
import com.block.aopstudy.exception.BusinessException;
import com.block.aopstudy.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author wangrongsong
 * @title: UserAuthentication
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/5 9:42 下午
 */
@Component
@Aspect
@Slf4j
public class UserAuthentication {
    /**
     * 切点
     */
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
//            "@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
//            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
//            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
//            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||" +
//            "@annotation(org.springframework.stereotype.Controller) ||" +
//            "@annotation(org.springframework.web.bind.annotation.RestController)")
    @Pointcut("@annotation(com.block.aopstudy.annotation.Auth)")
    void  requestMapping(){}


//    @Before("requestMapping()")
//    public Object before(JoinPoint joinPoint) throws Throwable {
//        Object target = joinPoint.getTarget();
//        log.info("target name==>{}",target.getClass().getName());
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        if(method!=null){
//            log.info("method name==>{}",method.getName());
//            Auth auth = method.getAnnotation(Auth.class);
//            String path = auth.path();
//            log.info("获取切入的注解的path===>{}",path);
//
//        }
//        log.info("获取切入方法的参数==>{}",joinPoint.getArgs());
//
//        return false;
//    }

    @Around("requestMapping()")
    public Object preHandlerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("拦截开始...");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String authType = request.getAuthType();
//        log.info("joinPoint--->{}",authType);
//        log.info("contentType----->{}",request.getContentType());
//        log.info("request uri---->{}",request.getRequestURI());
//        String uri = request.getRequestURI();
        log.info("request class:{}",joinPoint.getTarget().getClass().getName());
        log.info("request args:{}",joinPoint.getArgs());
        Object target = joinPoint.getTarget();
        log.info("proceedingJoinpoint request class:{}",joinPoint.getClass().getName());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if(method!=null){
            log.info("request method name:{}",method.getName());
            Auth auth = method.getAnnotation(Auth.class);
            String path = auth.path();
            log.info("request path:{}",auth.path());
            if(path.contains("/hello")){
                return joinPoint.proceed();
            }
            if(path.contains("/go_to_db")){
                String res = ResultBody.error(CommonEnum.NOT_AUTHORIZATION).toString();
                log.info("res:"+res);
                return res;
            }
        }
        return joinPoint.proceed();
    }
}
