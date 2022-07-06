package com.bantanger.leetcode.str;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/6 15:09
 */
public class LC1910 {
    class Solution {
        public String removeOccurrences(String s, String part) {
            StringBuffer sb = new StringBuffer();
            while (s.indexOf(part) >= 0) {
                sb.delete(0, sb.length());
                sb.append(s.substring(0, s.indexOf(part)));
                sb.append(s.substring(s.indexOf(part) + part.length()));
                s = sb.toString();
            }
            return sb.toString();
        }
    }
    @Test
    public void test() {
        String s = "daabcbaabcbc";
        String part = "abc";
        new Solution().removeOccurrences(s, part);
    }
}
