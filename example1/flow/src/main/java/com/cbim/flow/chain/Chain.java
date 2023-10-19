package com.cbim.flow.chain;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorContext;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Chain {
    public void run() throws IOException {
        /**
         * 读取责任链的配置
         * */

        readFlow("config/common/flowConfig.yml");

        /**
         * 执行责任链的前置模块
         * */
    }

    public void readFlow(String path) throws IOException {

        Yaml yaml = new Yaml(new Constructor(ActuatorContext.class));
        String configPath = new File("").getCanonicalPath() + File.separator + path;
        InputStream inputStream = new FileInputStream(new File(configPath));
        yaml.load(inputStream);
    }
}
