package com.bantanger.leetcode.weekly_competition.c295;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/29 10:45
 */
public class LC6078 {
    class Solution {
        public int rearrangeCharacters(String s, String target) {
            // 不能重复使用，那就直接统计字符出现的个数，
            int[] cs = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cs[s.charAt(i) - 'a']++;
            }
            char[] ch = target.toCharArray();
            int ans = 0;
            while(true) {
                for(int i = 0; i < ch.length; i++) {
                    cs[ch[i] - 'a']--;
                    if(cs[ch[i] - 'a'] < 0) return ans;
                }
                ans++;
            }
        }
    }
    @Test
    public void test() {
        String s = "abcba";
        String t = "abcz";
        System.out.println(new Solution().rearrangeCharacters(s, t));
    }
}
