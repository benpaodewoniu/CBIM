package com.cbim.cbim;

import com.cbim.flow.chain.Chain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CbimApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CbimApplication.class, args);

        Chain chain = new Chain();
        chain.run();
    }

}
