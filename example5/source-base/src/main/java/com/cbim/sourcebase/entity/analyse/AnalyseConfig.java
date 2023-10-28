package com.cbim.sourcebase.entity.analyse;

import lombok.Data;

@Data
public class AnalyseConfig {
    private String fieldName;
    private int placeholder;
    private int hexString;
    private String endian;
    private String tipZh;

    private int loopValue = 0; // 循环几次
    private boolean loopIf = false;
    private int[] loopOrders;
    private String loopFieldName;

    private int order;
}
