package com.cbim.cbim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cbim.flow.init.Init;

@SpringBootApplication
public class CbimApplication {

    public static void main(String[] args) {
        Init.init();
        SpringApplication.run(CbimApplication.class, args);
    }

}
