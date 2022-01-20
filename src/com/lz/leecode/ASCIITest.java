package com.lz.leecode;

public class ASCIITest {

    public static void main(String[] args) {
        //getSum(4, 5);
        System.out.println(88&87);
        System.out.println(Integer.toBinaryString(80&79));
        System.out.println(Integer.toBinaryString(80));
        System.out.println(Integer.toBinaryString(79));
//        System.out.println(hammingWeight(0b11111111111111111111111111111101));
        //System.out.println(isUnique("BACB"));
    }

    public static boolean isUnique(String astr) {
        long low64 = 0;
        long high64 = 0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << (c - 64);
                if ((high64 & bitIndex) != 0) {
                    return false;
                }
                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }
                low64 |= bitIndex;
            }
        }
        return true;
    }

    public static void print() {
        char[] chars = new char[]{
                'a', 'z', 'A', 'Z'
        };
        /*
        for (char ch :
                chars) {
            System.out.println(Integer.toBinaryString(Integer.valueOf(ch)));
            System.out.println((Integer.valueOf(ch)));
        }*/
        System.out.println(Long.toBinaryString(1L << 2));
        System.out.println(0b0001 << 3);
        System.out.println(17179869184l | 8589934592l);
        System.out.println(8 & 12);
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        System.out.println(n);
        while (n != 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            n = n>>1;
        }
        return count;
    }
}
