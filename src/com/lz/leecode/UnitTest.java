package com.lz.leecode;

import java.util.*;

public class UnitTest {

    public static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

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
        /*ListNode a = new ListNode(2);
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
        e2.next = f2;*/


//        ListNode{val=3, next=ListNode{val=6, next=ListNode{val=6, next=ListNode{val=8, next=ListNode{val=6, next=ListNode{val=2, next=ListNode{val=0, next=null}}}}}}}

//        243541  123321   3668620
//        145342    123321  268663

//        System.out.println(partition(a, 2).toString());
//        System.out.println(addTwoNumbers(a, a2));
//        System.out.println(reverseVowels("hello"));
//        System.out.println(validPalindrome("abc"));
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
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

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int len = numbers.length;
        int head = 0, tail = len-1;
        int sum = 0;
        while ( head < tail) {
            sum = numbers[head] + numbers[tail];
            if (sum == target) {
                return new int[]{++head, ++tail};
            } else if (sum > target) {
                tail--;
            } else {
                head++;
            }
        }
        return null;
    }

    public boolean judgeSquareSum(int c) {
        if (c == 0) return true;

        long head = 0, tail = (long) Math.sqrt(c), sum = 0;

        while (head <= tail) {
            sum = head * head + tail * tail;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                head++;
            } else {
                tail--;
            }
        }
        return false;
    }


    public static String reverseVowels(String s) {
        if (s==null) return null;
        int head = 0, tail = s.length()-1;
        char[] res = new char[s.length()];
        char headChar, tailChar;
         while (head <= tail) {

            headChar = s.charAt(head);
            tailChar = s.charAt(tail);

            if (!VOWELS.contains(headChar)) {
                res[head++] = headChar;
            } else if (!VOWELS.contains(tailChar)) {
                res[tail--] = tailChar;
            } else {
                res[head++] = tailChar;
                res[tail--] = headChar;
            }
        }
        return new String(res);
    }

    public static boolean validPalindrome(String s) {
        if (s == null) return false;
        for (int h = 0, t = s.length(); h < t; h++, t--) {
            if (s.charAt(h) != s.charAt(t)) {
                return isPalindrome(s, h+1, t) || isPalindrome(s, h, t-1);
            }
        }
        return false;
    }

    private static boolean isPalindrome(String s, int h, int t) {
        while (h < t) {
            if (s.charAt(h++) != s.charAt(t--)) {
                return false;
            }
        }
        return true;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m+n-1, tail1 = m-1, tail2 = n-1;
        for (int i = total; i >= 0; i--) {
            if (tail2 == -1) {
                nums1[i] = nums1[tail1--];
            }else if (tail1 == -1) {
                nums1[i] = nums2[tail2--];
            } else if (nums1[tail1] <= nums2[tail2]) {
                nums1[i] = nums2[tail2--];
            } else {
                nums1[i] = nums1[tail1--];
            }
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head.next;

        while (slow != null && fast != null && fast.next != null)
        {
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
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
