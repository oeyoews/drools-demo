package com.example.droolsdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Drools 规则执行响应对象
 *
 * 封装规则引擎执行后的返回结果，包括：
 * - success: 执行是否成功
 * - message: 执行消息
 * - data: 执行数据（规则触发次数、执行结果、耗时等）
 * - version: API 版本号
 *
 * @author Demo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleTestResponse {
    /** 执行是否成功 */
    private boolean success;

    /** 返回消息 */
    private String message;

    /** 规则执行数据 */
    private RuleTestData data;

    /** API 版本号 */
    private String version;
}