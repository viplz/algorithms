package com.lz.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        String key = "";
        boolean loop = false;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("list————遍历栈");
            System.out.println("exit————退出程序");
            System.out.println("push————入栈");
            System.out.println("pop————出栈");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "list" :
                    stack.list();
                    break;
                case "push" :
                    System.out.println("请输入一个数：");
                    int content = scanner.nextInt();
                    stack.push(content);
                    break;
                case "pop" :
                    try {
                        Integer ele = stack.pop();
                        System.out.printf("出栈的元素是%s", ele);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit" :
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序成功退出!");
    }
}
