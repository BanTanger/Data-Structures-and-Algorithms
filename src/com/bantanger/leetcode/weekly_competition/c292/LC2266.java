package com.bantanger.leetcode.weekly_competition.c292;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/25 13:24
 */
public class LC2266 {
    class Solution {
        public int countTexts(String pressedKeys) {
            // dp
            int MOD = (int) 1e9 + 7, n = pressedKeys.length();
            // 电话数字对应字母映射表
            int[] letter = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
            // 定义dp，每一个数字都可以作为一个字母独立出现，也可以与前面的数字结合构成新的字母。
            // 下标定义为 前 i 个数字可能映射成字母的情况数量
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1; // 边界情况处理
            /* 这里对双层for进行一个简单的说明，首先这是极度精简的代码 */
            for (int i = 2; i <= n; i++) {
                /* 外层for 处理当前指针指向 */
                char c = pressedKeys.charAt(i - 1); /* 取出当前执行的字符 */
                for (int j = i; j >= 1 &&
                        /* 内层for用于向前扩大数字区间 */
                        i - j + 1 <= letter[c - '0'] &&
                        /* 如果当前字符在字母映射表的存放的字母个数大于现在字符选取的长度 */
                        pressedKeys.charAt(j - 1) == c; j--) {
                        /* 当pressedKeys.charAt(j - 1) != c 方案数不会增加，
                         数字与之前不同，只能映射成单个字符，而不能和别的字符组合*/
                    dp[i] = (dp[i] + dp[j - 1]) % MOD;
                    /* 本来是dp的累加，因为可能会导致int爆掉，所以每次得到dp就取一次模*/
                }
            }
            return dp[n];
        }
    }
}
