package com.cbim.sourcebase.entity.analyse;

import lombok.Data;

@Data
public class AnalyseConfig {
    private String fieldName;
    private int placeholder;
    private int hexString = 1; // 1 -> 10 进制 2 -> 16 进制 3 -> UFT-8 字符串
    private String endian;
    private String tipZh;

    private int loopValue = 0; // 循环几次
    private boolean loopIf = false; // 是否在循环中
    private int[] loopOrders;
    private String loopFieldName;

    private int order;
}
