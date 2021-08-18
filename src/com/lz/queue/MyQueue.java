package com.lz.queue;

public class MyQueue {

}

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

    public void push(int n) {
        if (isFull()) {
            System.out.println("队列已满，存值失败！");
            return;
        }
//        尾部
        rear ++;
        data[rear] = n;
    }

    public int poll() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,取值失败！");
        }
//        头部后移
        front ++;
        return data[front];
    }

    public void foreach() {
        if (isEmpty()) {
            System.out.println("队列为空，遍历失败！");
            return;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("queue[%d] = %d \n", data[i]);
        }
    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，查询失败！");
        }
        return data[front + 1];
    }
}