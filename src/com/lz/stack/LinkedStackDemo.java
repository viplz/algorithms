package com.lz.stack;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName LinkedStackDemo.java
 * @Description TODO    单链表实现栈-案例
 * @createTime 2021年11月10日 00:06:49
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack(3);
        stack.push(new LinkedStackNode(11, "张三"));
        stack.push(new LinkedStackNode(12, "李四"));
        stack.push(new LinkedStackNode(13, "王五"));

        stack.pop();
        stack.push(new LinkedStackNode(14, "赵六"));
        stack.pop();
        stack.pop();
        stack.list();
        stack.pop();
        stack.pop();

        stack.list();
    }
}
