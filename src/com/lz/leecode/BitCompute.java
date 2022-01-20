package com.lz.leecode;

public class BitCompute {

    public static void main(String[] args) {
        int res = findSingleNum(new int[]{1,2,3,4,3,2,1,5,5});
        System.out.println(res);
    }

    public static int findSingleNum(int[] ary) {
        int res = 0;
        for (int i = 0, len = ary.length; i < len; i++) {
            res ^= ary[i];
        }
        return res;
    }
}
