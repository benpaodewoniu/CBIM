package com.cbim.sourcebase.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class NettyAddress {

    @Value("${tcp.client.host}")
    private String host;

    @Value("${tcp.client.port")
    private int port;
}
