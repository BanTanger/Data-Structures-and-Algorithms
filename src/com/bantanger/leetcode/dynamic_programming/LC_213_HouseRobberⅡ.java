package com.bantanger.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/12 10:08
 */
public class LC_213_HouseRobberⅡ {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            return Math.max(
                    robRange(nums, 0, nums.length - 1),
                    robRange(nums, 1, nums.length));
        }

        // start = 0 是情况二 范围:[0,length - 1)
        // start = 1 是情况三 范围:[1,length)
        private int robRange(int[] nums, int start, int end) {
            // 区间没有元素
            if (end == start) return nums[start];
            // 区间只有一个元素
            if (end == start + 1) return nums[start];
            int[] dp = new int[nums.length];
            dp[start] = nums[start];
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i < end; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[end - 1];
        }
    }
}
