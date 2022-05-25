package com.bantanger.leetcode.weekly_competition.c292;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/25 13:25
 */
public class LC2264 {
    class Solution {
        public String largestGoodInteger(String num) {
            // 直接内置，因为优质数只可能存在十种情况
            String[] arr = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
            for (String s : arr) {
                if (num.indexOf(s) >= 0) return s;
            }
            return "";
        }
    }
}
