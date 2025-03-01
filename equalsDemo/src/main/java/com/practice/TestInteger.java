package com.practice;

public class TestInteger {
    public static void main(String[] args) {
        int a1 = 20;
        Integer b1 = 20;
        System.out.println(a1 == b1);//true

        int a3 = 128;
        Integer b3 = 128;
        System.out.println(a3 == b3);//true

        Integer a4 = 10;
        Integer b4 = 10;
        System.out.println(a4 == b4);//true

        Integer a5 = 128;
        Integer b5 = 128;
        System.out.println(a5 == b5);//false

        Integer a6 = 127;
        Integer b6 = new Integer(127);
        System.out.println(a6 == b6);//false

        Integer a7 = new Integer(127);
        Integer b7 = new Integer(127);
        System.out.println(a7 == b7);//false
    }
}
