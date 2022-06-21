package com.bantanger.leetcode.str;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/21 19:27
 */
public class publicPrefixLong {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            // 先假定strs[0]是最长公共前缀
            String pre = strs[0];
            int i = 1;
            while (i < strs.length) {
                while (strs[i].indexOf(pre) != 0) { // 如果当前字符串不能以pre作为前缀
                    // 就进行修剪操作
                    pre = pre.substring(0, pre.length() - 1);
                }
                i++;
            }
            return pre;
        }
    }
}
