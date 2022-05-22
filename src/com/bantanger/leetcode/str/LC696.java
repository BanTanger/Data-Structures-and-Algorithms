package com.bantanger.leetcode.str;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 9:15
 */
public class LC696 {
    class Solution {
        public int countBinarySubstrings(String s) {
            int pre = 0, cur = 1, res = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    ++cur;
                } else {
                    pre = cur;
                    cur = 1;
                }
                /* 例如 110
                *  记录当前 pre 为 记录 1 的数据长度， 为2
                *     当前 cur 为 记录 0 的数据长度， 为1
                *  满足 pre >= cur 所以res 进一
                * */
                if (pre >= cur) {
                    res++;
                }
            }
            return res;
        }
    }
}
