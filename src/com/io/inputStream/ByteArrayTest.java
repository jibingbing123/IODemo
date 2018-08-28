package com.io.inputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * ByteArrayInputStream把字节数组类型转换成输入流类型
 * Created by jibingbing on 2018/1/8.
 */
public class ByteArrayTest {
    public static void main(String[] args) {
        byte[] buff = new byte[]{2,15,-7,69,-1,9};

        ByteArrayInputStream in = new ByteArrayInputStream(buff,1,4);
        int data = in.read();
        while(data != -1){
            System.out.println(data + " ");
            data = in.read();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
