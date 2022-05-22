package com.bantanger.leetcode.str;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 8:54
 */
public class LC205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            // 创建两个26长度的字符数组，用于存放s，t字符串的字符映射
            // 这里不单单是字符，是所有ASCII值，所以应该是256长度数组，这题目真蠢
            // 所以cs，ct已经开辟的够大了，就不用 -'a'，这样反而会导致下标变成负数
            int[] cs = new int[256];
            int[] ct = new int[256];
            for (int i = 0; i < s.length(); i++) {
                if (cs[s.charAt(i)] != ct[t.charAt(i)]) {
                    return false;
                }
                cs[s.charAt(i)] = ct[t.charAt(i)] = i + 1;
            }
            return true;
        }
    }
}
