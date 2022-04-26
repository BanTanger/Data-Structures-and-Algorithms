package com.bantanger.leetcode.kmp;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/26 9:20
 */
public class LC_459 {
    class Solution {
        /*
        (len - (next[len - 1] + 1)) 也就是： 12(字符串的长度) - 8(最长公共前后缀的长度) = 4，
         4正好可以被 12(字符串的长度) 整除，所以说明有重复的子字符串（asdf）
         */
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            if (n == 0) return false;
            int[] next = new int[n];
            getNext(next, s);
            /*
            最长相等前后缀的长度为：next[len - 1] + 1。(这里的next数组是以统一减一的方式计算的，因此需要+1)
            数组长度为：len。
            如果len % (len - (next[len - 1] + 1)) == 0 ，则说明 (数组长度-最长相等前后缀的长度)
            正好可以被 数组的长度整除，说明有该字符串有重复的子字符串。
            数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，
            如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
             */
            int j = -1;
            int len = s.length();
            if (next[len - 1] != -1 && len % (len - (next[len - 1] + 1)) == 0) {
                return true;
            }
            return false;
        }

        private void getNext(int[] next, String s) {
            int j = -1;
            next[0] = j;
            for (int i = 1; i < s.length(); i++) {
                while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                    j = next[j];
                }
                if (s.charAt(i) == s.charAt(j + 1)) j++; // i的增加在for里
                next[i] = j;
            }
        }
    }
}
