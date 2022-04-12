package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/12 9:00
 */
public class LC_198_HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            // 边界情况过滤
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            // 定义dp含义为在i号房时能偷窃的最高金额
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            // 没有对背包的限制，所以不需要遍历背包
            for (int i = 2; i < nums.length; i++) {
                // 如果当前房屋不打劫，
                // 那么当前收获的金额是当前房屋之前收到的金额dp[i - 1]，
                // 有点递归的意思，看宏观
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }
}
