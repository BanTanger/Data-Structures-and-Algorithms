package com.bantanger.leetcode.weekly_competition.c78;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 20:43
 */
public class LC2269 {
    // 将整型int转换成String，对String进行好处理的切割操作
    // Integer.valueOf将String转换成int
    class Solution {
        public int divisorSubstrings(int num, int k) {
            int n = (num + "").length();
            int res = 0;
            for(int i = 0; i <= n - k; i++) {
                int the = Integer.valueOf((num + "").substring(i, i + k));
                if(the != 0 && num % the == 0) {
                    res++;
                }
            }
            return res;
        }
    }
}
