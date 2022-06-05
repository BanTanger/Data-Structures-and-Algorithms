package com.bantanger.leetcode.weekly_competition.c296;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/5 23:18
 */
public class LC6902 {
    class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            // hash表映射
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < operations.length; i++) {
                int num = map.get(operations[i][0]);
                nums[num] = operations[i][1];
                map.put(nums[num], num);
            }
            return nums;
        }
    }
}
