package com.bantanger.leetcode.prefix;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/12 13:56
 */
public class LC303 {
    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
