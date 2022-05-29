package com.bantanger.leetcode.weekly_competition.c79;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 22:36
 */
public class LC6083 {
    class Solution {
        public boolean digitCount(String num) {
            HashMap<Integer, Integer> map = new HashMap<>(11);
            for(int i = 0; i < 11; i++) {
                map.put(i, 0);
            }
            char[] ch = num.toCharArray();
            for(int i = 0; i < ch.length; i++) {
                map.put((ch[i] - '0'), map.getOrDefault((ch[i] - '0'), 0) + 1);
            }
            for(int i = 0; i < ch.length; i++) {
                if((num.charAt(i) - '0') != map.get(i)) return false;
            }
            return true;
        }
    }
    @Test
    public void test() {
        String num = "1210";
        boolean b = new Solution().digitCount(num);
        System.out.println(b);
    }
}
