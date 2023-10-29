package com.cbim.flow.component;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcebase.entity.analyse.AnalyseInfo;
import com.cbim.sourcebase.entity.combine.CombineInfo;
import com.cbim.sourcebase.entity.cut.CutConfigList;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.cbim.flowbase.global.FlowGlobal.*;

@Component("beforeStart")
public class BeforeStart extends AbstractActuator {

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        /*
         * 读入 cutConfig.yaml 配置
         * */
        readCut("config/common/cutConfig.yml");

        /*
         * 读入 analyseConfig.yaml 配置
         * */
        readAnalyse("config/common/analyseConfig.yml");

        /*
         * 读入 combineConfig.yaml 配置
         * */
        readCombine("config/common/combineConfig.yml");
    }

    ;

    public void readCut(String path) throws IOException {
        Yaml yaml = new Yaml(new Constructor(CutConfigList.class));
        String configPath = new File("").getCanonicalPath() + File.separator + path;
        InputStream inputStream = new FileInputStream(configPath);
        CutConfigList cutConfigList = yaml.load(inputStream);
        cutConfigList.getConfigs().stream().forEach(s -> cutMapConfig.put(s.getKey(), s));
        ;

    }

    public void readAnalyse(String path) throws IOException {
        Yaml yaml = new Yaml(new Constructor(AnalyseInfo.class));
        String configPath = new File("").getCanonicalPath() + File.separator + path;
        InputStream inputStream = new FileInputStream(configPath);
        AnalyseInfo analyseInfo = yaml.load(inputStream);
        analyseInfo.getConfigs().stream().forEach(s -> analyseConfigListHashMap.put(s.getType(), s));
    }

    public void readCombine(String path) throws IOException {
        Yaml yaml = new Yaml(new Constructor(CombineInfo.class));
        String configPath = new File("").getCanonicalPath() + File.separator + path;
        InputStream inputStream = new FileInputStream(configPath);
        CombineInfo combineInfo = yaml.load(inputStream);
        combineInfo.getConfigs().stream().forEach(s -> combineConfigListHashMap.put(s.getType(), s));
    }

}
