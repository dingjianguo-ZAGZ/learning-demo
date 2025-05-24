package com.su.BIO;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIO {
    static boolean stop = false;
    public static void main(String[] args) throws Exception {
        int connectionNum = 0;//连接数
        int port = 8888; //端口号
        ExecutorService service = Executors.newCachedThreadPool(); //创建线程池
        ServerSocket serverSocket = new ServerSocket(port); //常见套接字
        while (!stop) {
            if (10 == connectionNum) {
                stop = true; //只接受10个连接
            }
            Socket socket = serverSocket.accept(); //接受连接
            service.execute(() -> {
                try {
                    Scanner scanner = new Scanner(socket.getInputStream()); //从客户端获取流，获取数据
                    PrintStream printStream = new PrintStream(socket.getOutputStream()); //将数据输出到流
                    while (!stop) {
                        String s = scanner.next().trim(); //接受输入数据，并去除首尾空白字符
                        printStream.println("PONG:" + s);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            connectionNum++;
        }
        service.shutdown();
        serverSocket.close();
    }
}
