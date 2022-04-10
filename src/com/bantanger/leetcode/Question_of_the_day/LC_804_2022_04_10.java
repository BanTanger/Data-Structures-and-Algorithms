package com.bantanger.leetcode.Question_of_the_day;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/10 9:39
 */
public class LC_804_2022_04_10 {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] Morse =
                    {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                            "....", "..", ".---", "-.-", ".-..", "--", "-.",
                            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                            "...-", ".--", "-..-", "-.--", "--.."};
            Set<String> set = new HashSet<>();
            for (String word : words) {
                StringBuilder str2 = new StringBuilder();
                for (char s : word.toCharArray()) {
                    str2.append(Morse[s - 'a']);
                }
                set.add(str2.toString());
            }
            return set.size();
        }
    }
}
