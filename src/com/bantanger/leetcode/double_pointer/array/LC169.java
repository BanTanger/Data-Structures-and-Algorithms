package com.bantanger.leetcode.double_pointer.array;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/30 16:34
 */
public class LC169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for(int i = 0; i < n; i++) {
                Integer integer = map.get(nums[i]);
                if(integer > n / 2) return nums[i];
            }
            return -1;
        }
    }
}
