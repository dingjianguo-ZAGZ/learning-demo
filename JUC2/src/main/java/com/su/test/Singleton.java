package com.su.test;

public class Singleton {
    private volatile Singleton instance = null;
    private Singleton(){

    }
    public Singleton getInstance(){
        if(instance!=null){
            synchronized (this){
                if(instance != null){
                    return instance;
                }
                instance = new Singleton();
            }
        }
        return instance;
    }
}
