package com.bantanger.leetcode.weekly_competition.c289;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/18 11:05
 */
public class LC2243_yes {
    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i += k) {
                    int n = 0;
                    for (int j = i; j < i + k && j < s.length(); ++j) {
                        n += Integer.parseInt(String.valueOf(s.charAt(j)));
                    }
                    sb.append(n);
                }
                s = sb.toString();
            }
            return s;
        }
    }
}
