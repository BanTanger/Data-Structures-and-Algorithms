package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/24 13:09
 */
public class LC_516_LongestPalindromeSub {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int len = 0;
            if (s == null || (len = s.length()) < 1) return 0;
            int[][] dp = new int[len + 1][len + 1];
            for (int i = len - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i + 1][j], dp[i][j - 1]), dp[i][j]);
                    }
                    System.out.println("==============");
                    System.out.println(s);
                    System.out.println(" i = " + i + " s.charAt(i) = " + s.charAt(i));
                    System.out.println(" j = " + j + " s.charAt(j) = " + s.charAt(j));
                    System.out.printf("dp[i][j] : dp[%d][%d] = %d\n", i, j, dp[i][j]);
                    System.out.println();
                }
            }
            // 根据定义，要返回[0,s.length())的结果，查看最终这个字符串包含几个回文子序列
            return dp[0][len - 1];
        }
    }

    @Test
    public void test() {
        new Solution().longestPalindromeSubseq("bbbab");
    }
}
