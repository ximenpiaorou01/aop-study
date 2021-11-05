package com.block.aopstudy.enums;

/**
 * @author wangrongsong
 * @title: BaseErrorInfoInterface
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/6 12:28 上午
 */
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     * @return
     */
    String getResultMessage();
}
