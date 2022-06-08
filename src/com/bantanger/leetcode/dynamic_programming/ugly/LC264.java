package com.bantanger.leetcode.dynamic_programming.ugly;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 12:14
 */
public class LC264 {
    class Solution {
        public int nthUglyNumber(int n) {
            // 动态规划加三指针方式
            int p_2, p_3, p_5;
            p_2 = p_3 = p_5 = 0; // 三指针指向同一个变量
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(dp[p_2] * 2, Math.min(dp[p_3] * 3, dp[p_5] * 5));
                if (dp[i] == dp[p_2] * 2) p_2++;
                if (dp[i] == dp[p_3] * 3) p_3++;
                if (dp[i] == dp[p_5] * 5) p_5++;
            }
            return dp[n - 1];
        }
    }

    @Test
    public void test() {
        new Solution().nthUglyNumber(10);
    }
}
