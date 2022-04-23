package com.bantanger.leetcode.sliding_window;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 11:03
 */
public class LC_567_NoRepeat {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : s1.toCharArray())
                need.put(c, need.getOrDefault(c, 0) + 1);
            int valid = 0;
            int left = 0, right = 0;
            while (right < s2.length()) {
                // 开始滑动
                // 右扩
                char c = s2.charAt(right++);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)))
                        valid++;
                }

                // 左缩
                while (right - left >= s1.length()) {
                    if (valid == need.size()) return true;
                    char d = s2.charAt(left++);
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d)))
                            valid--;
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }
    }
}
