package com.lz.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        HeroNode n1 = new HeroNode(1, "唐玄奘", "唐僧");
        HeroNode n2 = new HeroNode(2, "孙悟空", "美猴王");
        HeroNode n3 = new HeroNode(3, "猪八戒", "天蓬元帅");
        HeroNode n4 = new HeroNode(4, "沙悟净", "沙僧");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addNode(n1);
        linkedList.addNode(n3);
        linkedList.addNode(n2);
        linkedList.addNode(n4);

        linkedList.list();
    }
}

//单链表(不保证加入后的节点顺序)
class SingleLinkedList {
//  初始化头结点，确保节点不动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    public void addNode(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

//    遍历单链表
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head;
        while (true) {
            System.out.println(temp.toString());
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();

        }
    }
}

//英雄
class HeroNode {
//    英雄编号
    private int no;
//    英雄名称
    private String name;
//    英雄别名
    private String alias;
//    下一个英雄
    private HeroNode next;

    public HeroNode(int no, String name, String alias) {
        this.no = no;
        this.name = name;
        this.alias = alias;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                "}";
    }
}