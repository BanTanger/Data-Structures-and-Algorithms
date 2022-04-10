package com.bantanger.leetcode.dynamic_programming;

import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/10 9:00
 */
public class LC_139_dp {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // 定义dp：长度为i的字符串可以被拆分成一个或多个单词
            boolean[] valid = new boolean[s.length() + 1];
            // 特殊情况，方便推导
            valid[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    // 如果 [j , i]区间被字典包含，返回true，并且前面 [0, j] 在字典中，就可推导出 [0, i] 在字典中
                    if (wordDict.contains(s.substring(j, i)) && valid[j] == true) {
                        valid[i] = true;
                    }
                }
            }
            return valid[s.length()];
        }
    }
}
