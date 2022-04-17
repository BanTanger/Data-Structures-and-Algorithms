package com.bantanger.leetcode.Question_of_the_day;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/17 18:06
 */
public class LC_819_2022_04_17 {
    class Solution {
        /*
        使用StringTokenizer分割字符串
         */
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> res = new HashSet<>();
            for (String s : banned) {
                res.add(s);
            }
            // 使用StringTokenizer分割字符串
            StringTokenizer tokenizer = new StringTokenizer(paragraph.toLowerCase(), "!?',;. ");
            String ans = null;
            int cnt = 0;
            Map<String, Integer> map = new HashMap<>();
            while (tokenizer.hasMoreTokens()) {
                String s = tokenizer.nextToken();
                if (res.contains(s)) continue; // set容器使用contains判断是否存在键值，在map中是使用containsKey
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (map.get(s) > cnt) {
                    ans = s;
                    cnt = map.get(s);
                }
            }
            return ans;
        }

        /*
        使用指针遍历
         */

        /**
         *
         * @param paragraph
         * @param banned
         * @param p 用来占位重载
         * @return
         */
        public String mostCommonWord(String paragraph, String[] banned,String p) {
            Set<String> res = new HashSet<>();
            for (String s : banned) {
                res.add(s);
            }
            // java中没有C++，py那样方便的split，所以将字符串转换成字符数组处理
            char[] cs = paragraph.toCharArray();
            int n = cs.length;
            String ans = null;
            int cnt = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; ) {
                if (!Character.isLetter(cs[i]) && ++i >= 0) continue;
                int j = i;
                while (j < n && Character.isLetter(cs[j])) j++;
                String sub = paragraph.substring(i, j).toLowerCase();
                i = j + 1;
                if (res.contains(sub)) continue;
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if (map.get(sub) > cnt) {
                    cnt = map.get(sub);
                    ans = sub;
                }
            }
            return ans;
        }
    }
}
