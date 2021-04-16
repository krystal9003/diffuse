package com.han.demo.edition.two;

import com.han.demo.edition.common.User;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RemotingFourServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                User reqeustUser = (User) readObject;
                System.out.println("收到客户端的请求数据为:" + reqeustUser);
            }
            objectOutputStream.writeObject(new User());
        }
    }


}
