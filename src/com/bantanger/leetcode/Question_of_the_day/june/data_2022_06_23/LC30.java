package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/23 19:48
 */
public class LC30 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int len = words[0].length(); // 题目保证words里所有单词长度相同
            int l = 0, r = words.length * len, windowLen = r;
            HashMap<String, Integer> need = new HashMap<>();
            HashMap<String, Integer> window;
            List<Integer> res = new ArrayList<>();
            for (String word : words) {
                need.put(word, need.getOrDefault(word, 0) + 1);
            }
            if (s.length() < r) return res;
            while (r <= s.length()) { // 滑动窗口，窗口长度为整个words长度
                // 右扩
                String temp = s.substring(l, r); // 先提前从s抽取出与words长度相等的子串
                window = new HashMap<>();
                int wL = 0, wR = len; // 查看temp[wL, wR]范围的小单词是否在need中出现过
                // 左缩
                while (wR <= windowLen) {
                    String word = temp.substring(wL, wR);
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    wL = wR;
                    wR = wR + len;
                }
                if (window.equals(need)) res.add(l);
                l++;
                r++;
            }
            return res;
        }
    }
}
