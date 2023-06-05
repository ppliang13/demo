package com.spendreport.sent;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

/**
 * Created by pisiliang on 2023/6/1 14:20
 */
public class ReadFileSend {
    public static void main(String[] args) {
        File file = new File("D:\\work\\my\\demo\\frauddetection\\src\\main\\resources\\wordCount.txt");

        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(Files.newInputStream(file.toPath()));
            int tempchar;

            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
