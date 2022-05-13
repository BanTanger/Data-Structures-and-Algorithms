package com.bantanger.leetcode.difference_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 8:59
 */
public class LC370 {
    int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        DifferenceArray df = new DifferenceArray(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }
}
