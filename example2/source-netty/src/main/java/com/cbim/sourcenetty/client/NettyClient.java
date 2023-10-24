package com.cbim.sourcenetty.client;

import com.cbim.sourcebase.entity.NettyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyClient {

    @Autowired
    private NettyAddress nettyAddress;

    public void start(){
        System.out.println("success");
    }
}
