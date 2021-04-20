package com.han.demo.edition.three;


import com.han.demo.edition.common.User;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RemotingThreeClient {

    public static DiffuseRequest call(String ip, int port, DiffuseRequest user) throws Exception {
        Socket socket = new Socket(ip, port);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        ObjectOutputStream os = new ObjectOutputStream(outputStream);
        ObjectInputStream is = new ObjectInputStream(inputStream);
        os.writeObject(user);
        os.flush();
        Object response = is.readObject();
        if (response != null) {
            DiffuseRequest responseUser = (DiffuseRequest) response;
            System.out.println("收到服务端返回的数据为:" + responseUser);
            return responseUser;
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        DiffuseRequest<User> request = new DiffuseRequest<>();
        request.setCode("one");
        DiffuseRequest call = call("127.0.0.1", 8888, request);
        System.out.println(call);
    }

}
