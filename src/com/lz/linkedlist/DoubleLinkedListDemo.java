package com.lz.linkedlist;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName DoubleLinkedListDemo.java
 * @Description 双向链表案例
 * @createTime 2021年10月20日 00:10:08
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        
        HeroNode2 n1 = new HeroNode2(1, "唐玄奘", "唐僧");
        HeroNode2 n2 = new HeroNode2(2, "孙悟空", "美猴王");
        HeroNode2 n3 = new HeroNode2(3, "猪八戒", "天蓬元帅");
        HeroNode2 n4 = new HeroNode2(4, "沙悟净", "沙僧");

        DoubleLinkedList list = new DoubleLinkedList();
        list.addInOrder(n3);
        list.addInOrder(n2);
        list.addInOrder(n1);
        list.addInOrder(n4);

        list.list();
        System.out.println();

        HeroNode2 new_n4 = new HeroNode2(4, "三师弟", "老沙");
        list.update(new_n4);

        list.list();
        System.out.println();

        list.delete(3);
        list.list();
        System.out.println();
    }
}

//单链表
class DoubleLinkedList {
    //  初始化头结点，确保节点不动，不存放具体数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //添加节点
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pref = temp;
    }

    //顺序添加节点
    public void addInOrder(HeroNode2 node) {
        if (node == null || node.no == null) {
            System.out.println("当前节点不存在，无法添加！");
        }
        HeroNode2 temp = head;

        boolean isFind = false;

        while (true) {
            if (temp.next == null) {
                isFind = true;
                break;
            }
            //判断临时节点的下一个节点是否比当前节点的值大
            if (temp.next.no > node.no ) {
                isFind = true;
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("编号：" + node.no + " 已存在，不能添加");
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            //当前节点下一个节点指向临时节点的下一个节点
            node.next = temp.next;
            //当前节点的前一个节点指向临时节点
            node.pref = temp;
            //若临时节点的下一个节点不为空,则将临时节点的下一个节点的前向节点指向当前节点
            if (temp.next != null) {
                temp.next.pref = node;
            }
            //临时节点的下一节点指向当前节点
            temp.next = node;
        }
    }

    //更新节点
    public void update(HeroNode2 node) {
        if (node == null || node.no == null) {
            System.out.println("节点不存在，无法更新！");
        }
        boolean flag = false;
        HeroNode2 temp = head.next;
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
        HeroNode2 temp = head.next;
        while(temp != null) {
            if (temp.no == no) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            temp.pref.next = temp.next;
            if (temp.next != null) {
                temp.next.pref = temp.pref;
            }
        } else System.out.println("未匹配到待删除节点，无法删除！");
    }

    public void clear() {
        head = new HeroNode2(0 ,"", "");
    }

    //    遍历单链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

//英雄
class HeroNode2 {
    //    英雄编号
    public Integer no;
    //    英雄名称
    public String name;
    //    英雄别名
    public String alias;
    //    下一个英雄
    public HeroNode2 next;
    //    上一个英雄
    public HeroNode2 pref;

    public HeroNode2(int no, String name, String alias) {
        this.no = no;
        this.name = name;
        this.alias = alias;
    }


    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                "}";
    }
}
