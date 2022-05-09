package com.bantanger.leetcode.sliding_window;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/9 14:57
 */
public class LC209_MinSubArray {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length, sum = 0, min = Integer.MAX_VALUE;
            int l = 0, r = 0;
            for (r = 0; r < n; r++) {
                sum += nums[r];
                while (sum >= target) {
                    min = Math.min(min, r - l + 1);
                    sum -= nums[l++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
