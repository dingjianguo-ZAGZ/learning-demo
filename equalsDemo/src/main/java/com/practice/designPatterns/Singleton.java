package com.practice.designPatterns;

public class Singleton {
    //静态私有成员变量
    private static Singleton instance =null;
    //私有构造函数
    private Singleton(){}
    //静态公有工厂方法，返回唯一的实例
    synchronized public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    /*//静态私有成员变量
    private static final Singleton instance = new Singleton();
    //私有构造函数
    private Singleton(){}
    //静态公有工厂方法，返回唯一的实例
    public static Singleton getInstance(){
        return instance;
    }*/
}
