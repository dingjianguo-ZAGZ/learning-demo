package com.su.queue;

import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        //创建队列
        Queue queue = new Queue(3);
        char key = ' ';//接受用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s：显示队列");
            System.out.println("e：退出队列");
            System.out.println("a：添加元素");
            System.out.println("g：获取元素");
            System.out.println("p：获取第一个元素");
            key = sc.next().charAt(0);//接收一个字符
            switch (key){
                case 's': queue.show();break;
                case 'a':
                    System.out.println("请输入");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int poll = queue.poll();
                    System.out.println("取出的数据是："+poll);
                    break;
                case 'p':
                    int peek     = queue.peek();
                    System.out.println("第一个数据是："+peek);
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
    //使用数组实现自定义队列
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;//指向队列头部，分析出指向队列第一个元素前一个位置
        this.rear = -1;//指向队列尾部，分析出指出队列最后一个元素
        this.arr =new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //向队列中添加元素
    public void addQueue(int value){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列已满，不能添加元素");
            return;
        }
        arr[++rear] = value;
    }
    //获取元素，出队列
    public int poll(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，获取失败");
        }
        //将队首元素返回并移除，front移动，表示移除
        front++;
        return arr[front];
    }
    //查看队列第一个元素
    public int peek(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，获取失败");
        }
        return arr[front+1];
    }
    //显示队列所有数据
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //格式化打印数组
            System.out.println(arr[i]);
        }
    }
}
