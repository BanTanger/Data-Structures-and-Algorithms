package com.bantanger.leetcode.hash.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/4 8:32
 */
public class LC49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for(String str : strs) {
                char[] cs = str.toCharArray();
                Arrays.sort(cs);
                String key = new String(cs);
                if(!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
}
