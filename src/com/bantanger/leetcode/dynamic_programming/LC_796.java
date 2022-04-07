package com.bantanger.leetcode.dynamic_programming;


/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/7 13:40
 */
public class LC_796 {
    class Solution {
        public boolean rotateString(String s, String goal) {
            // 快慢指针
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                System.out.println(String.copyValueOf(chars));
                if (goal.equals(String.copyValueOf(chars))) return true;
                int fast = 1, slow = 0;
                char temp = chars[0];
                for (int i = 0; i < chars.length && fast != chars.length; i++) {
                    chars[slow++] = chars[fast++];
                }
                chars[chars.length - 1] = temp;
            }
            return false;
        }
    }
}
