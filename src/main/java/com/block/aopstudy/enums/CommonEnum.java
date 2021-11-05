package com.block.aopstudy.enums;

import lombok.*;

/**
 * @author wangrongsong
 * @title: CommonEnum
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/6 12:27 上午
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum CommonEnum implements BaseErrorInfoInterface{
    SUCCESS("200","成功"),
    NOT_FOUND("404", "未找到该资源!"),
    NOT_AUTHORIZATION("405","没有权限访问"),
    INTERNAL_SERVER_ERROR("500","服务器内部错误"),
    ;
    @Setter
    private String resultCode;
    @Setter
    private String resultMessage;

}
