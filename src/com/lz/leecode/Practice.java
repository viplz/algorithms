package com.lz.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName Practice.java
 * @Description TODO
 * @createTime 2022年02月20日 22:50:48
 */
public class Practice {

    public static void main(String[] args) {
        Practice practice = new Practice();
//        System.out.println(practice.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ",27));
        System.out.println(practice.isPalindrome("bab"));
    }

    public boolean isUnique(String astr) {
        char[] chAry = astr.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0, len = chAry.length; i < len; i++) {
            if (set.contains(chAry[i])){
                return false;
            } else {
                set.add(chAry[i]);
            }
        }
        return true;
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int len = s1.length();

        char[] ch1= s1.toCharArray();
        char[] ch2= s2.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(ch1[i], map.getOrDefault(ch1[i], 0) + 1);
            map.put(ch2[i], map.getOrDefault(ch2[i], 0) - 1);
        }

        for (Integer val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public String replaceSpaces(String S, int length) {
        char[] chs = S.toCharArray();
        int lastIndex = S.length() - 1;
        for (int i = length-1; i >= 0; i--) {
            if (chs[i] == ' ') {
                chs[lastIndex--] = '0';
                chs[lastIndex--] = '2';
                chs[lastIndex--] = '%';
            }else {
                chs[lastIndex--] = chs[i];
            }
        }
//        return new String(chs).substring(lastIndex+1);
        return new String(chs, lastIndex + 1, chs.length - lastIndex - 1);
    }

    /**
     * 是否回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int center = chars.length / 2;
        int right = center, left = center - 1;

        if ((s.length() & 1) == 1) {
            right++;
        }
        for (int i = left; i >= 0 ; i--) {
            if (chars[i] != chars[right++]) {
                return false;
            }
        }
        return true;
    }

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, len = chars.length; i < len; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
        }
        int n = 0;
        for (Integer val : map.values()) {
            if ((val & 1) == 1 && ++n > 1) {
                return false;
            }
        }
        return true;
    }

}
