package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/12 11:45
 */
public class LC890 {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            char c[] = pattern.toCharArray();
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (isMatched(c, words[i].toCharArray())) {
                    ans.add(words[i]);
                }
            }
            return ans;
        }

        boolean isMatched(char c[], char c1[]) {
            int map[] = new int[130];
            boolean hasMap[] = new boolean[130];
            Arrays.fill(map, -1);
            for (int i = 0; i < c.length; i++) {
                if (map[c[i]] == -1) {
                    if (hasMap[c1[i]]) {
                        return false;
                    }
                    map[c[i]] = c1[i];
                    hasMap[c1[i]] = true;
                } else if (map[c[i]] != c1[i]) {
                    return false;
                }
            }
            return true;
        }
    }


}
