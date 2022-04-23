package com.bantanger.leetcode.sliding_window;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 11:49
 */
public class LC_3_NoRepeatNumb {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int res = 0; // 记录结果
            while (right < s.length()) {
                char c = s.charAt(right++);
                // 进行窗口数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                while (window.get(c) > 1) { // 查看窗口是否有重复元素，如果有，就左缩
                    char d = s.charAt(left++);
                    window.put(d, window.get(d) - 1); // 删除一个重复元素，循环执行，直到只剩一个
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
