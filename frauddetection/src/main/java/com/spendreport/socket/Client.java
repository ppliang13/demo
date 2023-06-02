package com.spendreport.socket;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("成功连接服务器，请输入要发送的消息，按回车键发送：");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = consoleReader.readLine()) != null) {
            writer.println(line);
            System.out.println("发送成功");
        }
    }
}
