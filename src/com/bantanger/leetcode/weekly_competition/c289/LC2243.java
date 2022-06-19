package com.bantanger.leetcode.weekly_competition.c289;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/18 10:45
 */
public class LC2243 {
    class Solution {
        public String digitSum(String s, int k) {
            while(s.length() > k) {
                // 简单暴力模拟
                int n = s.length();
                int len = n % k == 0 ? n / k : n / k + 1;
                String[] str = new String[len];
                for(int i = 0, j = 0; i < n && j < len; i += k) {
                    if(i + k > n) {
                        str[j++] = s.substring(i);
                        break;
                    }
                    str[j++] = s.substring(i, i + k);
                }
                // 计算每组数字的和
                StringBuffer sb = new StringBuffer();
                for(String st : str) {
                    int m = st.length();
                    int sum = 0;
                    for(int i = 0; i < m; i++) {
                        sum += st.charAt(i);
                    }
                    sb.append(sum + "");
                }
                s = sb.toString();
            }
            return s;
        }
    }
    @Test
    public void test() {
        String s = "00000000";
        int k = 3;
//        System.out.println(s.substring(0, 12));
        new Solution().digitSum(s, k);
    }
}
