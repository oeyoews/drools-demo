package com.example.droolsdemo.util;

/**
 * 规则中使用的工具类（封装状态转换等通用方法）
 */
public class RuleUtils {
    // 私有构造器：防止实例化（工具类无需实例）
    private RuleUtils() {
        throw new AssertionError("工具类不允许实例化");
    }

    /**
     * 将boolean类型的成年状态转换为中文描述
     * @param isAdult 是否成年
     * @return "成年" 或 "未成年"
     */
    public static String getStatus(boolean isAdult) {
        return isAdult ? "成年" : "未成年";
    }
}