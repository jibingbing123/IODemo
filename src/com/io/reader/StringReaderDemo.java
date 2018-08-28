package com.io.reader;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by jibingbing on 2018/1/14.
 */
public class StringReaderDemo {
    public static void main(String[] args) throws IOException{
        String s = new String("hello jibingbing!");
        StringReader strReader = new StringReader(s);
        int data;
        while((data = strReader.read()) != -1){
            System.out.print((char) data + " ");
        }
        strReader.close();
    }
}
