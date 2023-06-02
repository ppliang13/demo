package com.spendreport.sent;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("成功连接服务器，请输入要发送的消息，按回车键发送：");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = consoleReader.readLine()) != null) {
            writer.println(line);
            if(line.equals("exit")){
                break;
            }
            System.out.println("发送成功");
        }
    }
}
