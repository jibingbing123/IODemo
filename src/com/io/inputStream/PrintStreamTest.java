package com.io.inputStream;

import java.io.*;

/**
 * Created by jibingbing on 2018/1/11.
 */
public class PrintStreamTest {
    public static void readBuff(byte[] buff) throws IOException{
        ByteArrayInputStream in = new ByteArrayInputStream(buff);
        int data;
        while((data = in.read()) != -1){
            System.out.print(data + " ");
        }
        System.out.println();
        in.close();
    }

    public static void main(String[] args) throws IOException{
        //通过PrintStream打印
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out,true);
        ps.print("好");
        ps.close();

        //获得字节数组
        byte[] buff = out.toByteArray();
        System.out.println("采用本地操作系统的默认字符编码:");
        readBuff(buff);

        //通过DataOutputStream打印
        out = new ByteArrayOutputStream();
        DataOutputStream ds = new DataOutputStream(out);
        ds.writeUTF("好");
        ds.close();

        buff =out.toByteArray();
        System.out.println("采用适用于Java语言的UTF-8编码:");
        readBuff(buff);
    }
}
