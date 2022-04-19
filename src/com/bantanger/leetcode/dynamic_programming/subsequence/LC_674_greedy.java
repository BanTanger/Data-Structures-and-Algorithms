package com.bantanger.leetcode.dynamic_programming.subsequence;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/19 10:23
 */
public class LC_674_greedy {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int result = 1;
            int count = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i])
                    count++; // 如果连续，长度增加
                else count = 1; // 不连续，count从头开始记录
                result = Math.max(count, result); // 记录最大长度
            }
            return result;
        }
    }
}
