package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_25;


import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 9:14
 */
public class LC467 {
    class Solution {
        public int findSubstringInWraproundString(String p) {
            // 子串是连续的
            // p = 'cac' 的子串有 c, a, ac, ca, cac
            // 对每一个字符作为结尾的最长连续子串进行统计。(可以覆盖掉重复的短序列情况)
            int n = p.length();
            char[] ch = p.toCharArray();
            int[] count = new int[26];
            int curMaxLen = 1;
            for (int i = 0; i < n; i++) {
                if (i > 0 && (ch[i] - ch[i - 1] == 1 || ch[i - 1] - ch[i] == 25)) {
                    curMaxLen++;
                } else {
                    curMaxLen = 1;
                }
                count[ch[i] - 'a'] = Math.max(count[ch[i] - 'a'], curMaxLen);
            }
            int res = 0;
            for (int num : count) {
                res += num;
            }
            return res;
        }
    }
}
