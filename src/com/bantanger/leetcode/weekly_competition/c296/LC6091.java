package com.bantanger.leetcode.weekly_competition.c296;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/5 23:18
 */
public class LC6091 {
    class Solution {
        public int partitionArray(int[] nums, int k) {
            // 排序加贪心
            if (nums.length == 1) {
                return 1;
            }
            Arrays.sort(nums);
            int count = 1;
            int min = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - min > k) {
                    count++;
                    min = nums[i];
                }
            }
            return count;
        }
    }
}
