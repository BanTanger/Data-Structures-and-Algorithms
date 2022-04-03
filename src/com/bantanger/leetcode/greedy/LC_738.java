package com.bantanger.leetcode.greedy;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/1 8:25
 */
public class LC_738 {
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            if (n == 0) return n;
            char[] chars = Integer.toString(n).toCharArray();
            int start = Integer.MAX_VALUE; // start初始化设为系统最大，避免数据已经是单调递增不用更改的情况
            for (int i = chars.length - 1; i > 0; i--) {
                if (chars[i] < chars[i - 1]) {
                    chars[i - 1]--;
                    start = i; // 使用start来标记从哪个位置开始赋值9
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0' && i == 0) continue; // 防止出现09的情况
                if (i >= start) {
                    res.append('9');
                } else res.append(chars[i]);
            }
            return Integer.parseInt(res.toString());
        }
    }
}
