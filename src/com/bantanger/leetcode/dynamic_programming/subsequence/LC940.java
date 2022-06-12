package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/11 21:31
 */
public class LC940 {
    class Solution {
        public int distinctSubseqII(String S) {
            long end[] = new long[26], mod = (long) 1e9 + 7;
            for (char c : S.toCharArray())
                end[c - 'a'] = Arrays.stream(end).sum() % mod + 1; // 代表以当前字符结尾的元素个数
            /*
            *             朴素推导 以 abc为例
            * ab 字符的字符序列为 a, b, ab
            * 这个序列遇到c时， 以c结尾的字符序列为 ab c, a c, b c
            * 朴素发现，对每一个字符序列加上新字母又是新的N个不同的序列
             */
            return (int) (Arrays.stream(end).sum() % mod);
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().distinctSubseqII("abc"));
    }
}
