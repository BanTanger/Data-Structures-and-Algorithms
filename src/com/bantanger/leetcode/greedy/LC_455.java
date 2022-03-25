package com.bantanger.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/25 9:10
 */
public class LC_455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            // return help1(g,s);
            return help2(g, s);
        }

        public int help1(int[] g, int[] s) {
            // 贪心：大饼干优先给大胃口
            Arrays.sort(g);
            Arrays.sort(s);
            int index = s.length - 1;
            int result = 0;
            for (int i = g.length - 1; i >= 0; i--) {
                if (index >= 0 && s[index] >= g[i]) {
                    index--;
                    result++;
                }
            }
            return result;
        }

        public int help2(int[] g, int[] s) {
            // 贪心：小饼干给小胃口
            Arrays.sort(g);
            Arrays.sort(s);
            int index = 0;
            for (int i = 0; i < s.length; i++) {
                if (index < g.length && g[index] <= s[i]) {
                    index++;
                }
            }
            return index;
        }
    }
}
