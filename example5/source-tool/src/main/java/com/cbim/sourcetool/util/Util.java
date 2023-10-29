package com.cbim.sourcetool.util;

import java.util.Map;

public class Util {

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
