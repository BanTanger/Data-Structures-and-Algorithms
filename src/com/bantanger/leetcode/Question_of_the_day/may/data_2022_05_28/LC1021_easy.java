package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_28;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 10:16
 */
public class LC1021_easy {
    class Solution {
        public String removeOuterParentheses(String s) {
            // 比较简洁的写法
            int count = 0; // 记录左括号数量
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' && count++ > 0) {
                    sb.append(c);
                } else if (c == ')' && --count > 0) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
