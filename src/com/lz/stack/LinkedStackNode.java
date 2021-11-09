package com.lz.stack;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName LinkedStackNode.java
 * @Description TODO    单链表栈节点
 * @createTime 2021年11月09日 23:31:50
 */
public class LinkedStackNode <T> {

    private Integer id;
    private Object name;
    private LinkedStackNode next;

    public LinkedStackNode(){}

    public LinkedStackNode(Integer id, Object name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public LinkedStackNode getNext() {
        return next;
    }

    public void setNext(LinkedStackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedStackNode{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
