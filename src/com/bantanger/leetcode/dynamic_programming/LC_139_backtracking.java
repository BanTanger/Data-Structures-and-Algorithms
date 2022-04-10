package com.bantanger.leetcode.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/10 9:24
 */
public class LC_139_backtracking {
    class Solution {
        Set<String> wordDictSet;
        int[] memory;

        public boolean wordBreak(String s, List<String> wordDict) {
            // 回溯
            wordDictSet = new HashSet(wordDict);
            memory = new int[s.length()];
            return backTracking(s, 0);
        }

        private boolean backTracking(String s, int startIndex) {
            // backTracking函数的如果不做任何处理就会返回false
            if (startIndex >= s.length()) return true;
            // 记忆化
            if (memory[startIndex] != 0) {
                // 认为memory[i] = 1表示可以拼出i和其以后的字符串
                return memory[startIndex] == 1;
            }
            for (int i = startIndex; i < s.length(); i++) {
                // 循环不变量，将字符串拆成 区间为[startIndex, i + 1) 的子串
                String word = s.substring(startIndex, i + 1);
                if (wordDictSet.contains(word) && backTracking(s, i + 1)) {
                    memory[startIndex] = 1;
                    return true; // 代表这个子串可以拼接
                }
            }
            memory[startIndex] = -1; // 将备忘录置空
            return false;
        }
    }
}
