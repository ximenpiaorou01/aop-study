package com.block.aopstudy.utils;

import com.block.aopstudy.enums.BaseErrorInfoInterface;
import com.block.aopstudy.enums.CommonEnum;
import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author wangrongsong
 * @title: ResultBody
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/6 12:40 上午
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResultBody<T> {

    private String code;
    private String message;
    private T data;

    public static <T> ResultBody<T> success(T data){
        return new ResultBody<T>()
                .setData(data)
                .setCode(CommonEnum.SUCCESS.getResultCode())
                .setMessage(CommonEnum.SUCCESS.getResultMessage());
    }

    public static <T> ResultBody<T> success(){
        return  success(null);
    }

    public static <T> ResultBody<T> error(BaseErrorInfoInterface infoInterface){
        return new ResultBody<T>()
                .setCode(infoInterface.getResultCode())
                .setMessage(infoInterface.getResultMessage())
                .setData(null);
    }

    public static <T> ResultBody<T> error(String code,String message){
        return new ResultBody<T>()
                .setCode(code)
                .setMessage(message)
                .setData(null);
    }

    public static <T> ResultBody<T> error(String message){
        return new ResultBody<T>()
                .setCode("-1")
                .setMessage(message)
                .setMessage(null);
    }

    public String toString(){
        return new Gson().toJson(this);
    }
}
