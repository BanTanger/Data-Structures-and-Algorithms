package com.bantanger.leetcode.weekly_competition;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/5 9:35
 */
public class LC1455 {
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] word = sentence.split(" ");
            for (String w : word) {
                if (w.length() < searchWord.length()) continue;
                if(searchWord.indexOf(w) > 0) return searchWord.indexOf(w);
            }
            return -1;
        }
    }
}
