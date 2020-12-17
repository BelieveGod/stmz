package com.stmz.mgr.actionExtend.webSocket;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/15 9:23
 */

@Slf4j
public class MyWebSocketClient extends WebSocketClient {

    public static final String WEBSOCKET_URI="ws://10.7.5.88:8089/gs-robot/notice/status";
    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log.info("websocket open");
    }

    @Override
    public void onMessage(String message) {
        log.debug("websocket receive:{}",message);
        JSONObject jsonObject = JSONUtil.parseObj(message);

    }

    @SneakyThrows
    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("websocket close,code:{},reason:{}",code,reason);
        System.out.println("尝试重连");
        for(int i=0;i<5;i++){
            boolean b = this.reconnectBlocking();
            System.out.println("重连"+ (b?"成功":"失败"));
            if(b){
                break;
            }
        }
       ;
    }

    @Override
    public void onError(Exception ex) {
        log.error("websocket error",ex);
    }

    public boolean connetRetry(int n) throws InterruptedException {
        boolean b=false;
        // 尝试重连五次
        for(int i=0;i<n;i++){
            System.out.println("第"+i+"次连接......");
             b= this.connectBlocking();
            if(b) break;
        }
        return b;
    }

    public static void main(String[] args) throws InterruptedException {
        URI uri = URI.create(MyWebSocketClient.WEBSOCKET_URI);
        MyWebSocketClient myWebSocketClient = new MyWebSocketClient(uri);
        // 最多尝试连接五次
        boolean b1 = myWebSocketClient.connetRetry(5);
        if(b1){
            System.out.println("running ...");
        }
        else{
            System.out.println("fail ....");
        }
        while(true);
    }
}
