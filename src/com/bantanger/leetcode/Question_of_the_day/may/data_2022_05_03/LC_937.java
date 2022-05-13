package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/3 22:05
 */
public class LC_937 {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int spaceIndex1 = s1.indexOf(' ');
                    int spaceIndex2 = s2.indexOf(' ');
                    char c1 = s1.charAt(spaceIndex1 + 1);
                    char c2 = s2.charAt(spaceIndex2 + 1);
                    if (!Character.isLetter(c1) && !Character.isLetter(c2)) return 0;
                    if (Character.isLetter(c1) && !Character.isLetter(c2)) return -1;
                    if (!Character.isLetter(c1) && Character.isLetter(c2)) return 1;
                    String s11 = s1.substring(0, spaceIndex1);
                    String s12 = s1.substring(spaceIndex1 + 1, s1.length());
                    String s21 = s2.substring(0, spaceIndex2);
                    String s22 = s2.substring(spaceIndex2 + 1, s2.length());
                    int i = s12.compareTo(s22);
                    if (i != 0) return i;
                    else return s11.compareTo(s21);
                }
            });
            return logs;
        }
    }

    @Test
    public void test() {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        new Solution().reorderLogFiles(logs);
    }
}
