package com.lz.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName LRUCache2.java
 * @Description TODO
 * @createTime 2022年02月11日 23:28:03
 */
public class LRUCache2 {


    /**
     * 构造Node节点作为数据载体
     *
     * @param <K>
     * @param <V>
     */
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    /**
     * 构造双向链表，装载每一个数据节点
     *
     * @param <K>
     * @param <V>
     */
    class DoubleLinkedList<K, V> {

        Node<K, V> head, tail;

        /**
         * 初始化双向链表、构造头尾哨兵节点
         */
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        /**
         * 添加到头结点
         *
         * @param node
         */
        public void addHead(Node<K, V> node) {
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;
        }

        /**
         * 删除节点
         *
         * @param node
         */
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = node.next = null;
        }

        /**
         * 获取最后一个节点
         *
         * @return
         */
        public Node getLast() {
            return this.tail.prev;
        }
    }

    private int capacity;
    /**
     * 用于查找
     */
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);

            node.value = value;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == capacity) {
                Node last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }


}
