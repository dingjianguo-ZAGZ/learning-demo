package com.su.BIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888); //创建服务器
            System.out.println("服务端已经启动，等待客户端连接");

            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端连接："+clientSocket.getInetAddress());
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            printWriter.println("欢迎连接服务器");

            //关闭资源
            serverSocket.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
