package com.lz.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
//        接收用户输入
        char key = ' ';
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s[show-显示队列]");
            System.out.println("a[add-添加队列]");
            System.out.println("e[exit-退出程序]");
            System.out.println("g[get-取队列])");
            System.out.println("h[head-查看队列头部]");
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
                        int res = queue.getHead();
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

//  该队列存在BUG：非环形队列，取完所有值后，无法再新增数值。
class ArrayQueue {
//    最大容量
    private int maxCapacity;
//    队列头
    private int front;
//    队列尾
    private int rear;
//    队列数据
    private int[] data;

    private ArrayQueue(){}

    public ArrayQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        data = new int[maxCapacity];
//        指向队列头的前一个位置
        front = -1;
//        指向队列尾部的位置
        rear = -1;
    }

    public boolean isFull() {
        return rear == (maxCapacity-1);
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满，存值失败！");
            return;
        }
//        尾部
        rear ++;
        data[rear] = n;
    }

    public int get() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,取值失败！");
        }
//        头部后移
        front ++;
        return data[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空，遍历失败！");
            return;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("queue[%d] = %d \n", i, data[i]);
        }
    }

    public int getHead()  throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，查询失败！");
        }
        return data[front + 1];
    }
}