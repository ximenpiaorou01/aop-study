package com.block.aopstudy.controller;

import com.block.aopstudy.annotation.Auth;
import com.block.aopstudy.enums.CommonEnum;
import com.block.aopstudy.utils.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author wangrongsong
 * @title: HelloController
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/5 9:39 下午
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @Auth(path = "/hello")
    public String hello(String name){
        return name+",hello,nice to meet you!";
    }

    @GetMapping("/go_to_db")
    @Auth(path = "/go_to_db")
    public String getToDb(String name){
        return name+",you have right to access the DB!";
    }

    @GetMapping("/eat")
    public String getTest(String name) throws UnsupportedEncodingException {
        String res = name+",like eat fresh meat";
        return new String(res.getBytes("utf-8"));
    }

}
