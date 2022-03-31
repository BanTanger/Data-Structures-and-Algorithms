package com.bantanger.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/31 9:14
 */
public class LC_763 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> list = new ArrayList<>();
            int[] edge = new int[26]; // 将26字母放在一个数组集合中，统计该字母最远位置
            char[] chars = s.toCharArray(); // 在java中String类型是不能被引用，不可变的，不能像C++那样直接对String进行操作，所以需要将String类型转化成字符数组，API为toCharArray
            for (int i = 0; i < chars.length; i++) {
                edge[chars[i] - 'a'] = i;
            }
            int index = 0;
            int last = -1;
            for (int i = 0; i < chars.length; i++) {
                index = Math.max(index, edge[chars[i] - 'a']);
                if (i == index) { // 当前遍历元素等于字符最远出现位置
                    list.add(i - last); // last = -1的目的是让 i-last得到长度，数组一开始从0开始。
                    last = i;
                }
            }
            return list;
        }
    }
}
