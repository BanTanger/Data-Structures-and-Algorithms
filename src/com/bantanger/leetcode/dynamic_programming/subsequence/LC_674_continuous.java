package com.bantanger.leetcode.dynamic_programming.subsequence;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/19 10:16
 */
public class LC_674_continuous {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 1) return 1;
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n - 1; i++) { // 因为是i + 1, 所以i < n - 1避免越界
                if (nums[i + 1] > nums[i])
                    dp[i + 1] = dp[i] + 1;
            }
            int result = 1;
            for (int x : dp) {
                result = Math.max(result, x);
            }
            return result;
        }
    }
}
