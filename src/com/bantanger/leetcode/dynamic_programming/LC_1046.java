package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/7 10:13
 */
public class LC_1046 {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int i : stones) {
                sum += i;
            }
            int target = sum >> 1; // 因为不确定能否分成等量两份，所以这里不需要判断奇偶
            int[] dp = new int[target + 1];
            for (int i = 0; i < stones.length; i++) {
                for (int j = target; j >= stones[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
            // 左背包减去右背包。因为左背包是通过sum算出的，必然会大于等于右背包
            return (sum - dp[target]) - dp[target];
        }
    }
}
