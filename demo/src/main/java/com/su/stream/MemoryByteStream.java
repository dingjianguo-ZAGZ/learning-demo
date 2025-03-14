package com.su.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MemoryByteStream {
    public static void main(String[] args) throws IOException {
        String str = new String("HELLO MEMORYBYTESTREAM");
        //创建字节数组输入流
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        //创建字节数组输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = bis.read()) != -1){
            //将读取的数据变成字符
            char c = (char) temp;
            //把字符变成小写
            bos.write(Character.toLowerCase(c));
        }
        //从输出流中取出数据
        String string = bos.toString();
        System.out.println(string);
        //关闭资源
        bis.close();
        bos.close();
    }
}
