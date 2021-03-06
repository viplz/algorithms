package com.lz.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        HeroNode n1 = new HeroNode(1, "唐玄奘", "唐僧");
        HeroNode n2 = new HeroNode(2, "孙悟空", "美猴王");
        HeroNode n3 = new HeroNode(3, "猪八戒", "天蓬元帅");
        HeroNode n4 = new HeroNode(4, "沙悟净", "沙僧");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(n1);
        linkedList.add(n3);
        linkedList.add(n2);
        linkedList.add(n4);

        System.out.println("----------新增节点如下：");
        linkedList.list();

        linkedList.update(new HeroNode(2, "孙猴子", "大师兄"));
        System.out.println("----------编辑节点如下：");
        linkedList.list();

        linkedList.clear();

        linkedList.addInOrder(n4);
        linkedList.addInOrder(n2);
        linkedList.addInOrder(n3);
        linkedList.addInOrder(n1);
        System.out.println("----------顺序新增节点如下：");
        linkedList.list();

        linkedList.delete(5);
        System.out.println("----------删除节点后情况如下：");
        linkedList.list();

    }
}

//单链表
class SingleLinkedList {
//  初始化头结点，确保节点不动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    //顺序添加节点
    public void addInOrder(HeroNode node) {
        if (node == null || node.no == null) {
            System.out.println("当前节点不存在，无法添加！");
        }
        HeroNode temp = head;
        if (temp.next == null) {
            temp.next = node;
            return;
        }
        HeroNode cur;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no ) {
                cur = temp.next;
                temp.next = node;
                node.next = cur;
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("编号：" + node.no + " 已存在，不能添加");
                break;
            }
            temp = temp.next;
        }
    }

    //更新节点
    public void update(HeroNode node) {
        if (node == null || node.no == null) {
            System.out.println("节点不存在，无法更新！");
        }
        boolean flag = false;
        HeroNode temp = head.next;
        while (true) {
            if (temp == null)
                break;
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = node.name;
            temp.alias = node.alias;
        }
    }

    //删除节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无需删除");
        }
        boolean isFind = false;
        HeroNode temp = head;
        while(temp != null) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            temp.next = temp.next.next;
        } else System.out.println("未匹配到待删除节点，无法删除！");
    }

    public void clear() {
        head = new HeroNode(0 ,"", "");
    }

//    遍历单链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

//英雄
class HeroNode {
//    英雄编号
    public Integer no;
//    英雄名称
    public String name;
//    英雄别名
    public String alias;
//    下一个英雄
    public HeroNode next;

    public HeroNode(int no, String name, String alias) {
        this.no = no;
        this.name = name;
        this.alias = alias;
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