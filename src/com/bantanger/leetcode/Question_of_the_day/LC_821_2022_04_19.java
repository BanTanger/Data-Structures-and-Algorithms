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
            Arrays.fill(res, n + 1); // 因为往右边遍历需要比较最小值，为了避免被0覆盖需要让数组初始化有值
            for (int i = 0, j = -1; i < n; i++) {
                if (s.charAt(i) == c) j = i; // 找到目标字符让指针都保持一致
                if (j != -1) res[i] = i - j; // j 指针不变 i 指针不停向前移
            }
            for (int i = n - 1, j = -1; i >= 0; i--) {
                if (s.charAt(i) == c) j = i; // 找到目标字符让指针都保持一致
                if (j != -1) res[i] = Math.min(res[i], j - i); // 从右到左做减法，进入当前条件代表j比i大，细品
            }
            return res;
        }
    }
}
