package com.su.stream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileByteStreamTest {
    public static void write(String fileName) throws Exception{
        //创建文件对象
        File file = new File(fileName);
        //创建文件字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //写入
        String str = "hello FileByteStream";
        //创建缓冲区
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        outputStream.write(bytes);
        //关闭资源
        outputStream.close();
    }
    public static void read(String fileName) throws Exception{
        //创建文件对象
        File file = new File(fileName);
        //创建文件字节输出流
        InputStream inputStream = new FileInputStream(file);
        //创建缓冲区
        byte[] bytes = new byte[(int) file.length()];//数组长度用 int 类型
        //从缓冲区读数据 ,返回读取记录的数量
        int len = inputStream.read(bytes);
        System.out.println("数据长度为："+len);
        //关闭资源
        inputStream.close();
        System.out.println("内容为："+new String(bytes));
    }

    public static void main(String[] args) throws Exception {
        String fileName = "d:/file.txt";
        write(fileName);
        read(fileName);
    }
}
