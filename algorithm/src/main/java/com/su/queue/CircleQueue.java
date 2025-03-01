package com.su.queue;

import java.util.Scanner;

public class CircleQueue {
    public static void main(String[] args) {
        //创建队列
        CircleQueue circleQueue = new CircleQueue(4);
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
                case 's': circleQueue.show();break;
                case 'a':
                    System.out.println("请输入");
                    int value = sc.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    int poll = circleQueue.poll();
                    System.out.println("取出的数据是："+poll);
                    break;
                case 'p':
                    int peek     = circleQueue.peek();
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
    private int front;//指向队列头部，分析出指向队列第一个元素
    private int rear;//指向队列尾部，分析出指出队列最后一个元素的后一个位置，空出一个位置 (区分队列为空 还是 满)
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr =new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        arr[rear]= value;
        rear = (rear + 1) % maxSize;
    }
    //获取元素，出队列
    public int poll(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，获取失败");
        }
        //将队首元素返回并移除，front移动，表示移除
        int value = arr[front];
        front++;
        return value;
    }
    //查看队列第一个元素
    public int peek(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，获取失败");
        }
        return arr[front];
    }
    //显示队列所有数据
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //从front开始，遍历多少个结束
        for (int i = front; i < size() + front; i++) {
            //格式化打印数组
            System.out.println(arr[i]);
        }
    }
    //当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}
