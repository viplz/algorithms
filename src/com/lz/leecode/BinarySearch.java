package com.lz.leecode;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName BinarySearch.java
 * @Description TODO
 * @createTime 2022年01月11日 00:24:40
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
