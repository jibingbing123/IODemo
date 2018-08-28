package com.io.inputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/**
 * SequenceInputStream可以将多个流串联在一起,合并为一个输入流
 * Created by jibingbing on 2018/1/8.
 */
public class SequenceTest {
    public static void main(String[] args) {
        InputStream s1 = new ByteArrayInputStream("你".getBytes());
        InputStream s2 = new ByteArrayInputStream("好".getBytes());

        InputStream in = new SequenceInputStream(s1,s2);
        try {
            int data;
            while((data = in.read()) != -1){
                System.out.print(data + " ");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
