package com.bantanger.string;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 18:07
 */
public class LC541_reverseStr {
    class Solution {
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            int n = s.length();
            for (int i = 0; i < n; i += 2 * k) {
                // 每次步进2k长度
                // 1. 每隔 2k 个字符的前 k 个字符进行反转
                // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
                int start = i;
                int end = Math.min(n - 1, i + k - 1); // 这个逻辑非常好
                // 当i + k 大于 总长度，就直接取end为总长度翻转整个字符串。
                // 当i + k 小于 总长度，说明只需要翻转 (i, i + k - 1) 个元素就可
                while (start < end) {
                    ch[start] ^= ch[end];
                    ch[end] ^= ch[start];
                    ch[start] ^= ch[end];
                    start++;
                    end--;
                }
            }
            return new String(ch);
        }
    }
}
