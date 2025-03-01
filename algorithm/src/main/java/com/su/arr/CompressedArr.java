package com.su.arr;

import java.io.*;

public class CompressedArr {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[7][7];//棋盘大小
        arr[1][2] = 1;//红子
        arr[2][3] = 2;//黑子
        arr[3][4] = 1;

        for (int[] ints : arr) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i]+"\t");
                if(i == ints.length - 1){
                    System.out.print("\n");
                }
            }
        }

        //压缩数组 (行：数组中有值的元素个数+1  列：3)
        int sum = 0;
        for (int[] ints : arr) {
            for (int i : ints) {
                if(i != 0) sum++;
            }
        }
        //System.out.println(row);
        int[][] compressedArr = new int[sum+1][3];
        compressedArr[0][0] = arr.length; //原数组的行
        compressedArr[0][1] = arr[0].length; //原数组的列
        compressedArr[0][2] = sum; //有值的个数
        int row = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0){
                    compressedArr[row][0] = i;
                    compressedArr[row][1] = j;
                    compressedArr[row][2] = arr[i][j];
                    row++;
                }
            }
        }
        System.out.println("------------------------");
        for (int[] ints : compressedArr) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + "\t");
                if(i == 2) System.out.print("\n");
            }
        }
        //将压缩后的数组写入文件保存
        FileWriter fileWriter = new FileWriter("E:\\chess.txt");
        for (int[] ints : compressedArr) {
            for (int i : ints) {
                fileWriter.write(i+" ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
        System.out.println("-------------已存档------------");

        //读取存档文件，恢复棋盘
        // 1.读取文件
        BufferedReader reader = new BufferedReader(new FileReader("E:\\chess.txt"));
        String line = null;
        int rowCount = 0;//行数
        // 2.创建二维数组
        int[][] compressedArr2 = null;
        while ((line = reader.readLine()) != null){
            String[] s = line.split(" ");
            if(compressedArr2 == null){
                //第一行元素的最后一个值加一，等于行数
                compressedArr2 = new int[Integer.parseInt(s[2])+1][3];
            }
            int[] rowArr = new int[3];
            for (int i = 0; i < s.length; i++) {
                rowArr[i] = Integer.parseInt(s[i]);
            }
            compressedArr2[rowCount++] = rowArr;
        }
        reader.close();
        for (int[] ints : compressedArr2) {
            for (int i : ints) {
                System.out.print(i+"\t");
            }
            System.out.print("\n");
        }
        //恢复成棋盘
        int row2 = compressedArr2[0][0];
        int cul2 = compressedArr2[0][1];
        int[][] arr2 = new int[row2][cul2];
        for (int i = 1; i < compressedArr2.length; i++) {
            arr2[compressedArr2[i][0]][compressedArr2[i][1]] = compressedArr2[i][2];
        }
        //输出
        for (int[] ints : arr2) {
            for (int i : ints) {
                System.out.print(i+"\t");
            }
            System.out.print("\n");
        }
    }
}
