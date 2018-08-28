package com.io.inputStream;

import java.io.*;

/**
 * Created by jibingbing on 2018/1/9.
 */
public class FilterOutputTest {
    public static void main(String[] args) throws IOException{
        FileOutputStream out1 = new FileOutputStream("/Users/jibingbing/Desktop/test.txt");
        //把缓冲区的大小设为两个字节,在执行out.writeUTF("你好啊")时先把字符串的UTF-8编码写到缓冲区中,当超过两个字节时
        //再把缓冲区的数据写入到test.txt文件中
        BufferedOutputStream out2 = new BufferedOutputStream(out1,256);
        DataOutputStream out = new DataOutputStream(out2);
        out.writeUTF("你好啊");
        out.flush();

        InputStream in1 = new FileInputStream("/Users/jibingbing/Desktop/test.txt");
        BufferedInputStream in2 = new BufferedInputStream(in1);
        DataInputStream in = new DataInputStream(in2);
        System.out.println(in.readUTF());
        in.close();
    }
}
