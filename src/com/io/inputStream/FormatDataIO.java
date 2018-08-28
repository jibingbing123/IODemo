package com.io.inputStream;

import java.io.*;

/**
 * Created by jibingbing on 2018/1/8.
 */
public class FormatDataIO {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("/Users/jibingbing/Desktop/demo.txt");
        BufferedOutputStream buffOut = new BufferedOutputStream(fileOut);
        DataOutputStream dataOut = new DataOutputStream(buffOut);
        dataOut.writeByte(-12);
        dataOut.writeFloat(34);
        dataOut.writeChar('c');
        dataOut.writeUTF("季");
        dataOut.close();

        FileInputStream fileIn = new FileInputStream("/Users/jibingbing/Desktop/demo.txt");
        BufferedInputStream buffIn = new BufferedInputStream(fileIn);
        DataInputStream dataIn = new DataInputStream(buffIn);
        System.out.print(dataIn.readByte() + " ");
        System.out.print(dataIn.readFloat() + " ");
        System.out.print(dataIn.readChar() + " ");
        System.out.print(dataIn.readUTF() + " ");
        dataIn.close();
    }
}
