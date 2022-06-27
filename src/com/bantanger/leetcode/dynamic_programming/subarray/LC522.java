package com.bantanger.leetcode.dynamic_programming.subarray;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/27 20:14
 */
public class LC522 {
    class Solution {
        public int findLUSlength(String[] strs) {
            int len = strs.length, ans = -1;
            for (int i = 0; i < len; i++) {
                if (ans >= strs[i].length()) continue;
                boolean ok = true;
                for (int j = 0; j < len && ok; j++) {
                    if (i == j) continue;
                    // 检查strs[i]是否是字符数组的一个子序列，如果是就把ok置为false
                    if (check(strs[i], strs[j])) ok = false;
                }
                if (ok) ans = strs[i].length();
            }
            return ans;
        }

        private boolean check(String p, String q) {
            // LC1143检查公共子序列题目
            int n = p.length(), m = q.length();
            if (n > m) return false;
            p = " " + p;
            q = " " + q; // 追加空格哨兵
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (p.charAt(i) == q.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                    if (dp[i][j] == n) return true;
                    // System.out.print(dp[i][j] + " ");
                }
                // System.out.println();
            }
            // 是否公共长度等于p的长度，如果是，就代表p为q的一个子序列
            return false;
        }
    }

    @Test
    public void test() {
        String[] strs = {"sgbmipa","sgbmipa","hywi","hywi","emcfnmfp","zyhmw","vln","vln","k","sphmrawaxq","u","u","nhvhesfqca","nhvhesfqca","mhibqj","mhibqj"};
        new Solution().findLUSlength(strs);
    }
}
