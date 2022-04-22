package com.bantanger.leetcode.double_pointer;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 23:05
 */
public class LC_5_LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) return s;
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 找奇数回文
                String odd = palindrome(s, i, i);
                // 找偶数回文
                String even = palindrome(s, i, i + 1);
                res = res.length() > odd.length() ? res : odd;
                res = res.length() > even.length() ? res : even;
            }
            return res;
        }

        private String palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++; // 从中间向两边扩散
            }
            return s.substring(left + 1, right);
        }
    }
}
