package com.bantanger.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 11:25
 */
public class LC_438_All_Anagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : p.toCharArray())
                need.put(c, need.getOrDefault(c, 0) + 1);
            int l = 0, r = 0;
            int valid = 0;
            List<Integer> res = new ArrayList<>();
            while (r < s.length()) {
                char c = s.charAt(r++);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)))
                        valid++;
                }

                System.out.println(valid);
                /*** debug 输出的位置 ***/
                System.out.printf("window: [%d, %d)\n", l, r);
                /********************/

                while (r - l >= p.length()) {
                    if (valid == need.size()) res.add(l);
                    char d = s.charAt(l++);
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d)))
                            valid--;
                        window.put(d, window.get(d) - 1);
                    }
                }
                System.out.println(res.toString());
            }
            return res;
        }
    }
    @Test
    public void test(){
        String s = "aa";
        String t = "bb";
        new Solution().findAnagrams(s,t);
    }
}
