package com.bantanger.leetcode.weekly_competition.c292;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/25 13:25
 */
public class LC2266_moni {
    class Solution {
        public String largestGoodInteger(String num) {
            // substring，再随便取一位数字作为除数（不能是零），如果 / 得到的结果是111，代表是一个优质数
            int n = num.length();
            String ans = "";
            for (int i = 0; i < n - 2; i++) {
                String str = num.substring(i, i + 3);
                if (str.charAt(0) == str.charAt(1) && str.charAt(0) == str.charAt(2)) {
                    if (ans.equals("") || Integer.parseInt(str) > Integer.parseInt(ans))
                        ans = str;
                }
            }
            return ans;
        }
    }
}
