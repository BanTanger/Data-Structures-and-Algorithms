package com.bantanger.leetcode.Nsum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/7 19:18
 */
public class LC1_TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 使用hashMap
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0 ; i < nums.length; i++){
                if(!map.containsKey(target - nums[i])){
                    map.put(nums[i], i);
                } else {
                    return new int[]{map.get(target - nums[i]) ,i};
                }
            }
            return new int[]{-1, -1};
        }
    }
    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int[] ints = new Solution().twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
