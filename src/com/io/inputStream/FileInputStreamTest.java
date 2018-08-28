package com.io.inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jibingbing on 2018/1/8.
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("/Users/jibingbing/Desktop/test.txt");
            FileOutputStream out = new FileOutputStream("/Users/jibingbing/Desktop/out.txt");

            byte[] buff = new byte[1024];
            int data = in.read(buff);
            while(data != -1){
                out.write(buff,0,data);
                data = in.read(buff);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
