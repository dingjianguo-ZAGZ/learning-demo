package com.practice;

public class TestString {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(s1 == s2);//true

        String s3 = new String("b");
        String s4 = new String("b");
        System.out.println(s3 == s4);//false

        String s5 = new String("c").intern();
        String s6 = new String("c").intern();
        System.out.println(s5 == s6);//true

        String s7 = new String("d");
        String s8 = new String("d");
        System.out.println(s7.equals(s8));//true

    }
}
