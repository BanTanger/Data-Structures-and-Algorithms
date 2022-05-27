package com.bantanger.leetcode.weekly_competition.c77;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/27 16:07
 */
public class LC2255 {
    class Solution {
        public int countPrefixes(String[] words, String s) {
            // 暴力比较
            int ans = 0;
            for (String word : words) {
                if (isPrime(word, s)) ans++;
            }
            return ans;
        }

        private boolean isPrime(String word, String s) {
            if (word.length() > s.length()) return false;
            // 从小的遍历，如果发现不相同就返回false
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != s.charAt(i)) return false;
            }
            return true;
        }
    }
}
