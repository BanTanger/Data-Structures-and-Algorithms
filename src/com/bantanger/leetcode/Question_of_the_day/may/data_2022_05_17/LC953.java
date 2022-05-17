package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_17;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 13:00
 */
public class LC953 {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] hashmap = new int[26];
            for (int i = 0; i < 26; i++) hashmap[order.charAt(i) - 'a'] = i;
            String[] clone = words.clone();
            Arrays.sort(clone, (a, b) -> {
                int n = a.length(), m = b.length();
                int i = 0, j = 0;
                while (i < n && j < m) {
                    int c1 = a.charAt(i) - 'a';
                    int c2 = b.charAt(i) - 'a';
                    if (c1 != c2) return hashmap[c1] - hashmap[c2];
                    i++;
                    j++;
                }
                if (i < n) return 1;
                if (j < m) return -1;
                return 0;
            });
            int n = words.length;
            for (int i = 0; i < n; i++) {
                if (!clone[i].equals(words[i])) return false;
            }
            return true;
        }
    }
}
