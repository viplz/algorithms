package com.lz.leecode;

public class BinarySearch {

    private int v1 = 10;
    private final int v2 = 12;
    private static final int v3 = 12;

    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
