package com.lz.stack;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName ArrayStack.java
 * @Description TODO
 * @createTime 2021年11月08日 22:25:32
 */
public class ArrayStack <T> {

//  栈
    private T[] stack;
//  栈的最大空间
    private int maxSize;
//  栈顶位置
    private int topPos = -1;
//  私有化无参构造
    private ArrayStack(){}
//  初始化栈
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = (T[]) new Object[this.maxSize];
    }

//  是否栈满
    public boolean isFull() {
        return topPos == (this.maxSize - 1);
    }

//  是否栈空
    public boolean isEmpty() {
        return topPos == -1;
    }

//  入栈
    public void push(T ele){
        if (isFull()) {
            return;
        }
        this.stack[topPos++] = ele;
    }

//  出栈
    public T pop() {
       if (isEmpty()) {
           throw new RuntimeException("栈空，无法出栈！");
       }
       T ele = this.stack[topPos];
       topPos--;
       return ele;
    }
//  遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无法遍历！");
            return;
        }
        for (int i = topPos; i >=0 ; i--) {
            System.out.printf("stack[%d]=%s", i, stack[i]!=null ? stack[i].toString() : null);
        }
    }
}
