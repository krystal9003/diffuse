package com.han.demo.edition.two;

import com.han.demo.edition.common.User;

import java.io.*;
import java.net.Socket;

public class RemotingFourClient {

    public static User call(String ip, int port, User user) throws Exception {
        Socket socket = new Socket(ip, port);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        ObjectOutputStream os = new ObjectOutputStream(outputStream);
        ObjectInputStream is = new ObjectInputStream(inputStream);
        os.writeObject(user);
        os.flush();
        Object response = is.readObject();
        if (response != null) {
            User responseUser = (User) response;
            System.out.println("收到服务端返回的数据为:" + responseUser);
            return responseUser;
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        String ip = "127.0.0.1";
        int port = 8888;
        User user = new User();
        user.setName("dongwei");
        user.setAge(18);
        call(ip, port, user);
    }


}
