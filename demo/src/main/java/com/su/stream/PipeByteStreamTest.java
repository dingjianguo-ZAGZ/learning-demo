package com.su.stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

public class PipeByteStreamTest {
    static private class Send implements Runnable{
        //创建管道输出流
        private PipedOutputStream pos = null;
        Send(){
            //构造方法，初始化变量
            pos = new PipedOutputStream();
        }

        /**
         * 重写run 方法，创建新的线程
         */
        @Override
        public void run() {
            String str = "HELLO PIPEBYTESTREAM";
            //向管道写入数据
            try {
                pos.write(str.getBytes(StandardCharsets.UTF_8));
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 提供获取管道字节流的方法
         * @return
         */
        public PipedOutputStream getPos(){
            return pos;
        }
    }
    static private class Receive implements Runnable{
        private PipedInputStream pis = null;

        public Receive() {
            this.pis = new PipedInputStream();
        }

        @Override
        public void run() {
            //创建缓冲区
            byte[] b = new byte[1024];
            int len = 0;
            try {
                len = pis.read(b);
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("接收到的内容为："+new String(b,0,len));
        }
        /**
         * 提供获取管道字节流的方法
         * @return
         */
        public PipedInputStream getPis(){
            return pis;
        }
    }

    public static void main(String[] args) {
        Send s = new Send();
        Receive r = new Receive();
        PipedOutputStream pos = s.getPos();
        PipedInputStream pis = r.getPis();
        try {
            pos.connect(pis); //连接管道
        } catch (IOException e) {
            e.printStackTrace();
        }
        //启动线程
        new Thread(s).start();
        new Thread(r).start();

    }
}
