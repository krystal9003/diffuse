package com.han.demo.edition.two;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class RemotingTwoClient {

    public static String call(String ip, int port, String message) throws IOException {
        try {
            Socket s = new Socket(ip, port);
            //构建IO
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            //向服务器端发送一条消息
            bw.write(message);
            bw.flush();
            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("服务器：" + mess);
            return mess;
        } catch (IOException e) {
            throw e;
        }
    }


    public static void main(String[] args) throws IOException {
        String call = call("127.0.0.1", 8888, "测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
        System.out.println(call);
    }

}
