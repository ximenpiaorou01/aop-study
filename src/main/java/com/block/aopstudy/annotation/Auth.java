package com.block.aopstudy.annotation;

import java.lang.annotation.*;

/**
 * @author wangrongsong
 * @title: auth
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/5 11:19 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
    public String path() default "";
}
