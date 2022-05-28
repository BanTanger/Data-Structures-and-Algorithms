package com.bantanger.leetcode.weekly_competition.c294;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 22:18
 */
public class LC2278 {
    class Solution {
        public int percentageLetter(String s, char letter) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == letter) {
                    res++;
                }
            }
            return (int) ((double) res / s.length() * 100);
        }
    }
}
