package com.io.inputStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 两个线程可以通过管道来通信
 * 当线程A执行管道输入流的read()方法时,如果暂时还没有数据,那么这个线程会被阻塞,
 * 只有当线程B向管道输出流写入数据时,线程A才会恢复运行
 * Created by jibingbing on 2018/1/8.
 */
class Sender extends Thread {
    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    public void run(){
        try {
            for(int i = -127;i < 128;i++){
                out.write(i);
                yield();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Receiver extends Thread {
    private PipedInputStream in;

    public Receiver(Sender sender){
        try {
            in = new PipedInputStream(sender.getOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            int data;
            while((data = in.read()) != -1){
                System.out.println(data);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        sender.start();
        receiver.start();
    }
}
