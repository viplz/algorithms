package com.lz.leecode;

import java.util.*;

public class UnitTest {


    /**
     * 'a', 'a', 'b', 'b'
     * 'a', 'a', 'b', 'b'
     *
     * @param args
     */

    public static void main(String[] args) {
//        System.out.println(new UnitTest().compressString("aabcccccaaa"));
//        int[][] aa = new int[][]{{0, 1, 1, 2}, {3, 4, 6, 5}, {1, 8, 0, 1}};
//        new UnitTest().setZeroes(aa);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        ListNode d2 = new ListNode(3);
        ListNode e2 = new ListNode(2);
        ListNode f2 = new ListNode(1);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        e2.next = f2;


//        ListNode{val=3, next=ListNode{val=6, next=ListNode{val=6, next=ListNode{val=8, next=ListNode{val=6, next=ListNode{val=2, next=ListNode{val=0, next=null}}}}}}}

//        243541  123321   3668620
//        145342    123321  268663

//        System.out.println(partition(a, 2).toString());
        System.out.println(addTwoNumbers(a, a2));
    }


    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;

        int firstLength = first.length(), secondLength = second.length();

        if (Math.abs(firstLength - secondLength) > 1) return false;

        if (firstLength < secondLength) return oneEditAway(second, first);

        for (int i = 0; i < secondLength; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i + 1).equals(second.substring(firstLength == secondLength ? i : i + 1));
            }
        }
        return true;
    }

    public String compressString(String S) {
        if (S == null || S.length() < 3) return S;

        StringBuilder sb = new StringBuilder();

        char[] chars = S.toCharArray();
        int length = chars.length;

        int chIndex = 0, chCount = 1;

        for (int i = 1; i < length; i++) {
            if (chars[chIndex] == chars[i]) {
                chCount++;
            } else {
                sb.append(chars[chIndex]).append(chCount);
                chIndex = i;
                chCount = 1;
            }
        }
        sb.append(chars[chIndex]).append(chCount);
        return sb.toString().length() >= length ? S : sb.toString();
    }


    public void rotate(int[][] matrix) {
        if (matrix.length == 0) return;

        int len = matrix.length;

        int[][] newMatrix = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                newMatrix[len - j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }


    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;

        int rows = matrix.length, cols = matrix[0].length;

        boolean catchZero = false;
        int[] hasNotZeroRows = new int[rows];

        System.out.println("-----------old------------");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-----------old------------");

        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }


        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; ) {
                if (catchZero) {
                    matrix[i][j] = 0;
                    j++;
                    if (j == cols) {
                        catchZero = false;
                    }
                }else {
                    if (matrix[i][j] == 0) {
                        catchZero = true;
                        j = 0;
                    } else {
                        j++;
                    }
                }
            }
        }*/

        System.out.println("-----------new------------");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-----------new------------");

    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        StringBuilder sb = new StringBuilder(2 * s2.length()).append(s2).append(s2);
        if (sb.indexOf(s1) > -1) {
            return true;
        }
        return false;
    }

    /*public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode temp = head;
        while (temp.next != null) {
            if (!set.add(temp.next.val)) {
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
        return head;
    }*/

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode n1 = head;

        while (n1 != null) {
            ListNode n2 = n1;
            while (n2.next != null) {
                if (n2.val == n1.val) {
                    n2.next = n2.next.next;
                } else {
                    n2 = n2.next;
                }
            }
            n1 = n1.next;
        }
        return head;
    }

    public int kthToLast(ListNode head, int k) {
//        1, 2, 3, 4, 5  {2}
//        4 (3)
//        a=1 b=1 i=0
//        a=2 b=1 i=1
//        a=3 b=2 i=2
//        a=4 b=3 i=3
//        a=5 b=4 i=4

        if (head == null) return -1;

        ListNode n1, n2;
        n1 = n2 = head;

        int index = 0;

        while (n2 != null) {

            if (index++ >= k) {
                n1 = n1.next;
            }
            n2 = n2.next;
        }
        return n1.val;


    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node = node.next;
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode littleHead = new ListNode(0), greatHead = new ListNode(0);

        ListNode little = littleHead, great = greatHead;

        while (head != null) {
            if (head.val >= x) {
                great.next = head;
                great = great.next;
            } else {
                little.next = head;
                little = little.next;
            }
            head = head.next;
        }
        little.next = greatHead.next;
        great.next = null;
        return littleHead.next;
    }

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * 示例：
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
     * 示例：
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     * Related Topics
     * 递归
     * 链表
     * 数学
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode node = result;
        int i = 0;
        while (l1 != null || l2 != null) {

            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += i;
            i = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        if (i > 0) {
            node.next = new ListNode(i);
        }
        return result.next;
    }

    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     * 示例 1：
     * 输入： 1->2
     * 输出： false
     * 示例 2：
     * 输入： 1->2->2->1
     * 输出： true
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * Related Topics
     * 栈
     * 递归
     * 链表
     * 双指针
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

//        1->3->4->3->1
//        slow=1,fast=1,prev=1;
//        slow=3,fast=4,prev=


        while (fast != null && fast.next != null) {
            ListNode oldCur = slow;
            slow = slow.next;
            fast = fast.next.next;
            oldCur.next = prev;
            prev = oldCur;
        }
        if (fast != null) { // 链表个数为奇数
            slow = slow.next;
        } // 判断pre和slow是否相等
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "\nListNode{" + "val=" + val + ", next=" + (next != null ? next : null) + "}";
    }
}
