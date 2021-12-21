package com.block.aopstudy.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangrongsong
 * @title: DataApplicationContext
 * @projectName aop-study
 * @description: TODO
 * @date 2021/12/20 10:36 下午
 */
@Slf4j
public class DataApplicationContext {

    private static final ThreadLocal<String> dataLocal=new ThreadLocal<>();

    public static void set(String data){
        dataLocal.set(data);
    }

    public static String get(){
        return dataLocal.get();
    }

    public static void remove(){
        dataLocal.remove();
    }

}
