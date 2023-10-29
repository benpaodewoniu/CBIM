package com.cbim.sourcetool.util;

import java.util.Map;

public class Util {

    // 辅助方法：将字节数组转换为十六进制字符串
    public static  String bytesToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            // 使用两个字符的十六进制表示，并用空格分隔
            hexString.append(String.format("%02X ", b));
        }
        return hexString.toString().trim();
    }

    public static String mapToString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }

        // 删除末尾多余的逗号
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append("}");

        String result = stringBuilder.toString();

        return result;
    }
}
