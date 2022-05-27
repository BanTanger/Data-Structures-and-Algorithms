package com.bantanger.leetcode.weekly_competition.c291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/26 23:38
 */
public class LC2259 {
    class Solution {
        // 直接对字符串集合排序

        public String removeDigit(String number, char digit) {
            int n = number.length();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (number.charAt(i) == digit) {
                    list.add(number.substring(0, i) + number.substring(i + 1, n));
                }
            }
            Collections.sort(list); /* 排序找最大，而不是使用max去比较大小，会爆的 */
            return list.get(list.size() - 1);
        }
    }
}
