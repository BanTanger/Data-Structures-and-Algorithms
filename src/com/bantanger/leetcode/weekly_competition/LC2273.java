package com.bantanger.leetcode.weekly_competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/19 22:03
 */
public class LC2273 {
    class Solution {
        public List<String> removeAnagrams(String[] words) {
            List<String> res = new ArrayList<>();
            String preSortWord = "";
            for (String word : words) {
                String SortWord = sort(word);
                if (!SortWord.equals(preSortWord)) {
                    res.add(word);
                    /*要注意这里add的是word而不是sortword,保证没有异位词的单词结构不改变*/
                    preSortWord = SortWord;
                }
            }
            return res;
        }

        /* 进行字典排序，将异位词都变成同一个单词 */
        public String sort(String word) {
            char[] cs = word.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}
