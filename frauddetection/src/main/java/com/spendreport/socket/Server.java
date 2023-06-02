package com.spendreport.socket;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动，等待客户端连接...");
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("收到来自客户端的消息：" + line);
        }
    }

}
