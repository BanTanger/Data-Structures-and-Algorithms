package com.bantanger.leetcode.Question_of_the_day.may.data_2022_06_01;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/1 22:24
 */
public class LC473 {
    class Solution {
        public boolean ans;

        public void dfs(int[] matchsticks, int max, int l, int a, int b, int c, int d) {
            // 剪枝
            if (ans == true) return;
            if (a > max || b > max || c > max || d > max) return;
            if (l == matchsticks.length) {
                if (a == b && a == c && a == d) {
                    if (a != 0) {
                        ans = true;
                    }
                }
                return;
            }
            dfs(matchsticks, max, l + 1, a + matchsticks[l], b, c, d);
            dfs(matchsticks, max, l + 1, a, b + matchsticks[l], c, d);
            dfs(matchsticks, max, l + 1, a, b, c + matchsticks[l], d);
            dfs(matchsticks, max, l + 1, a, b, c, d + matchsticks[l]);
        }

        public boolean makesquare(int[] matchsticks) {
            if (matchsticks.length < 4) {
                return false;
            }
            int sum = 0;
            int max = 0;
            for (int i : matchsticks) {
                sum += i;
                max = Math.max(i, max);
            }
            if (sum % 4 != 0) {
                return false;
            }
            if (max > sum / 4) {
                return false;
            }
            ans = false;
            dfs(matchsticks, sum / 4, 0, 0, 0, 0, 0);
            return ans;
        }
    }
}
