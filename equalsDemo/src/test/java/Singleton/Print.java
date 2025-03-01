package Singleton;

import com.practice.designPatterns.Singleton;

public class Print {
    //静态私有成员变量
    private static Print instance = null;
    //私有构造函数

    public Print() {
    }

    //静态公有工厂方法，返回唯一的实例
    public static Print getInstance(){
        if(instance == null){
            System.out.println("连接打印机");
            instance = new Print();
        }else{
            System.out.println("打印机正在工作");
        }
        return instance;
    }

}
