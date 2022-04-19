package com.bantanger.leetcode.Question_of_the_day;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/19 22:26
 */
public class LC_821_2022_04_19 {
    class Solution {
        public int[] shortestToChar(String s, char c) {
            int n = s.length();
            int[] res = new int[n];
            Arrays.fill(res, n + 1);
            for (int i = 0, j = -1; i < n; i++) {
                if (s.charAt(i) == c) j = i;
                if (j != -1) res[i] = i - j;
            }
            for (int i = n - 1, j = -1; i >= 0; i--) {
                if (s.charAt(i) == c) j = i;
                if (j != -1) res[i] = Math.min(res[i], j - i);
            }
            return res;
        }
    }
}
