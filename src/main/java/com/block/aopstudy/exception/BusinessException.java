package com.block.aopstudy.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangrongsong
 * @title: BusinessException
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/6 12:37 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private String errCode;
    private String errMsg;

}
