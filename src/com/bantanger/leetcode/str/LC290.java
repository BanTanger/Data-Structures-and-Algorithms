package com.bantanger.leetcode.str;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/17 16:27
 */
public class LC290 {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] str = s.split(" ");
            HashMap<Character, String> map = new HashMap<>();
            if(pattern.length() != str.length) return false;
            for(int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (map.containsKey(c) && !map.get(c).equals(str[i])) return false;
                map.put(c, str[i]);
            }
            return map.size() ==
                    map.values().stream().collect(Collectors.toSet()).size();
            /*简明答意。表示的是对map的键值进行去重，如果多个键对应一个值或者多个值对应一个键的情况就会被删去*/
        }
    }
    @Test
    public void test() {
        String pattern = "aaaa";
        String s = "dog cat cat dog";
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().wordPattern(pattern, s));
    }
}
