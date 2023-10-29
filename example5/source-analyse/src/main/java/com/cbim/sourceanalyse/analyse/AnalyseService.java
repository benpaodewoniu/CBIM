package com.cbim.sourceanalyse.analyse;

import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.flowbase.entity.TransferInfo;
import com.cbim.sourcebase.entity.analyse.AnalyseConfig;
import com.cbim.sourcebase.entity.analyse.AnalyseConfigList;
import com.cbim.sourcetool.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cbim.flowbase.global.FlowGlobal.*;

@Component("analyseService")
public class AnalyseService {

    private static final Logger logger = LoggerFactory.getLogger(AnalyseService.class);

    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        logger.info("使用配置解析原始数据");

        clear();

        run();

    }

    private void clear() {
        analyseDataHashMap.clear();
    }

    private void run() {
        for (String key : analyseConfigListHashMap.keySet()) {

            Map<String, String> mapData = new HashMap<>();

            byte[] data = cutMapData.get(key);
            TransferInfo transferInfo = new TransferInfo();

            AnalyseConfigList analyseConfigList = analyseConfigListHashMap.get(key);
            List<AnalyseConfig> analyseConfigs = analyseConfigList.getContent();

            Map<Integer, AnalyseConfig> analyseConfigMap = new HashMap<>();
            analyseConfigs.stream().forEach(s -> analyseConfigMap.put(s.getOrder(), s));

            for (AnalyseConfig analyseConfig : analyseConfigs) {

                int loopValue = analyseConfig.getLoopValue();
                boolean loopIf = analyseConfig.isLoopIf();

                if (loopIf == false && loopValue == 0) {
                    String fieldName = analyseConfig.getFieldName();
                    String value = getContent(transferInfo, analyseConfig, data);
                    mapData.put(fieldName, value);
                }

                if (loopValue > 0) {
                    String loopFieldName = analyseConfig.getLoopFieldName();
                    String value = getContentList(transferInfo, analyseConfig, analyseConfigMap, data);
                    mapData.put(loopFieldName, value);
                }

            }

            analyseDataHashMap.put(key, Util.mapToString(mapData));

        }
    }

    private String getContentList(TransferInfo transferInfo, AnalyseConfig analyseConfig, Map<Integer, AnalyseConfig> analyseConfigMap, byte[] originContent) {

        int loopValue = analyseConfig.getLoopValue();
        int[] loopOrders = analyseConfig.getLoopOrders();
        List<AnalyseConfig> analyseConfigList = new ArrayList<>();
        Map<String, String> mapData = new HashMap<>();

        /*
         * 统计循环中的 analyse 配置
         * */
        for (int i : loopOrders) {
            analyseConfigList.add(analyseConfigMap.get(i));
        }

        /*
         * 最外层循环存放处
         * */
        List<String> valueList = new ArrayList<>();

        for (int i = 0; i < loopValue; i++) {

            Map<String, String> mapDataSub = new HashMap<>();

            for (AnalyseConfig analyseConfigSub : analyseConfigList) {

                int loopValueSub = analyseConfigSub.getLoopValue();
                boolean loopIf = analyseConfigSub.isLoopIf();

                if (loopIf == true) {
                    String fieldName = analyseConfigSub.getFieldName();
                    String value = getContent(transferInfo, analyseConfigSub, originContent);
                    mapDataSub.put(fieldName, value);
                }

                if (loopValueSub > 0) {
                    String loopFieldName = analyseConfigSub.getLoopFieldName();
                    String valueSub = getContentList(transferInfo, analyseConfigSub, analyseConfigMap, originContent);
                    mapDataSub.put(loopFieldName, valueSub);
                }

            }

            valueList.add(Util.mapToString(mapDataSub));
        }

        return valueList.toString();
    }

    private String getContent(TransferInfo transferInfo, AnalyseConfig analyseConfig, byte[] originContent) {

        int offset = transferInfo.getOffset();
        int placeholderSize = analyseConfig.getPlaceholder();

        byte[] data = new byte[placeholderSize];

        System.arraycopy(originContent, offset, data, 0, placeholderSize);

        String value = getValue(analyseConfig, data);

        transferInfo.setOffset(transferInfo.getOffset() + placeholderSize);

        return value;

    }

    private String getValue(AnalyseConfig analyseConfig, byte[] content) {
        String result = "";
        String endian = analyseConfig.getEndian();
        int hexString = analyseConfig.getHexString();
//        if (endian.equals("little")) {
//
//        } else {
//
//        }
        result = bytesToString(hexString, content);
        return result;
    }

    private String bytesToString(int hexString, byte[] content) {

        switch (hexString) {
            case 1:
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : content) {
                    // 转化为 16 进制字符
                    String hex = String.format("%02X", b);
                    // 16 进制字符串转为为 10 进制数字
                    int decimal = Integer.parseInt(hex, 16);

                    stringBuilder.append((decimal));
                }

                // 删除前面的 0
                return stringBuilder.toString().replaceFirst("^0+(?!$)", "");
            case 2:
                return Util.bytesToHexString(content);
            case 3:
                return new String(content, StandardCharsets.UTF_8).trim();
            default:
                return null;
        }
    }
}
