package com.lz.queue;

import java.util.Scanner;

public class CircleQueueDemo {

    public static void main(String[] args) {
//        队列元素最多仅有3个，预留了一个空间供循环使用
        CircleQueue queue = new CircleQueue(4);
//        接收用户输入
        char key = ' ';
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show(显示队列)");
            System.out.println("add(添加队列)");
            System.out.println("exit(退出程序)");
            System.out.println("get(取队列)");
            System.out.println("head(查看队列头)");
//            接收一个字母
            key = in.next().charAt(0);
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个需要入队的数：");
                    int num = in.nextInt();
                    queue.add(num);
                    break;
                case 'g':
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据为：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.head();
                        System.out.printf("取出的头部数据为：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}

class CircleQueue {

    //    最大容量
    private int maxCapacity;
    //    队列头,指向队列第一个元素
    private int front;
    //    队列尾，指向队列最后一个元素的后一个位置
    private int rear;
    //    队列数据
    private int[] data;

    public CircleQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        data = new int[maxCapacity];
    }
    public boolean isFull() {
        return  (rear + 1) % maxCapacity == front;
    }
    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满，存值失败！");
            return;
        }
        data[rear] = n;
        rear = (rear+1) % maxCapacity;
    }
    public int get() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,取值失败！");
        }
        int val = front;
        front = (front + 1) % maxCapacity;
        return val;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空，遍历失败！");
            return;
        }
        for (int i = 0; i < front + size(); i++) {
            System.out.printf("queue[%d] = %d \n", i % maxCapacity, data[i%maxCapacity]);
        }
    }

    public int head()  throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，查询失败！");
        }
        return data[front];
    }

    public int size() {
        return (rear + maxCapacity - front) % maxCapacity;
    }
}
