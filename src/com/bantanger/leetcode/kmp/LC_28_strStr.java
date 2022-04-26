package com.bantanger.leetcode.kmp;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/26 8:43
 */
public class LC_28_strStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            if (m == 0) return 0;
            int[] next = new int[m]; // 创建一个与字符串等长的next数组
            getNext(next, needle);
            for (int i : next) {
                System.out.println(i + " ");
            }
            int j = -1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = next[j];
                }
                // 如果 s[i] 与 t[j + 1] 相同，那么i 和 j 同时向后移动
                if (haystack.charAt(i) == needle.charAt(j + 1)) j++; // i的增加在for循环里
                if (j == m - 1) return (i - m + 1);
            }
            return -1;
        }

        private void getNext(int[] next, String s) {
            // 定义整体右移的next数组
            int j = -1;
            next[0] = j;
            for (int i = 1; i < s.length(); i++) { // i 要从 1开始
                while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) { // 前后缀不相同了，j指针回退到前缀表对应位置
                    j = next[j];
                }
                if (s.charAt(i) == s.charAt(j + 1)) j++; // 找到相同的前后缀
                next[i] = j; // 将j（前缀的长度）赋给next[i]
            }
        }
    }
    @Test
    public void test(){
        new Solution().strStr("hello","ll");
    }
}
