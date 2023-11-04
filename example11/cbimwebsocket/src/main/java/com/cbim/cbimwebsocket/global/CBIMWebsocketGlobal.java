package com.cbim.cbimwebsocket.global;

import org.yeauty.pojo.Session;

import java.util.concurrent.ConcurrentHashMap;

public class CBIMWebsocketGlobal {
    public static ConcurrentHashMap<Session, Boolean> sessionMap = new ConcurrentHashMap<>();
}
