package com.lz.stack;

import org.w3c.dom.Node;

import java.util.Stack;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName LinkedStack.java
 * @Description TODO
 * @createTime 2021年11月09日 23:28:46
 */
public class LinkedStack {

    private static final LinkedStackNode head = new LinkedStackNode(Integer.MIN_VALUE, "root");

    private int maxSize;

    private int topPos = -1;

    private LinkedStack() {}

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return (maxSize-1) == topPos;
    }
    public boolean isEmpty() {
        return topPos == -1;
    }

    public void push(LinkedStackNode node) {
        if (isFull()) {
            System.out.println("栈满，入栈失败！");
            return;
        }
        LinkedStackNode lastNode = this.last();
        lastNode.setNext(node);
        topPos++ ;
    }

    public LinkedStackNode pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，出栈失败！");
        }
        LinkedStackNode popNode = null;
        LinkedStackNode node = this.beforeLast();
        popNode = node.getNext();
        node.setNext(null);
        return popNode;
    }

    public void list() {
        int index = 0;
        LinkedStackNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.printf("stack[%d]= %s \n", index, temp.toString());
            temp = temp.getNext();
            index++;
        }
    }

    private LinkedStackNode beforeLast() {
        LinkedStackNode temp = head;
        for (int i = 0; i < topPos ; i++) {
            temp = temp.getNext();
        }
        topPos--;
        return temp;
    }

    public LinkedStackNode last() {
        LinkedStackNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }
}

