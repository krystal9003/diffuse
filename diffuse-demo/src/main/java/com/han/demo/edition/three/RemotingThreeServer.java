package com.han.demo.edition.three;

import com.han.demo.edition.three.handler.OneBizHandler;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RemotingThreeServer {

    private static Map<String, BizHandler> serviceMap = new HashMap<>();

    public static void init() {
        serviceMap.put("one", new OneBizHandler());
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        init();
        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                DiffuseRequest reqeustUser = (DiffuseRequest) readObject;
                System.out.println("收到客户端的请求数据为:" + reqeustUser);
                String code = reqeustUser.getCode();
                BizHandler bizHandler = serviceMap.get(code);
                DiffuseRequest invoke = bizHandler.invoke(reqeustUser);
                objectOutputStream.writeObject(invoke);
            }
        }
    }

}
