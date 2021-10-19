package com.lz.linkedlist;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName DoubleLinkedListDemo.java
 * @Description 双向链表案例
 * @createTime 2021年10月20日 00:10:08
 */
public class DoubleLinkedListDemo {


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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                "}";
    }
}
