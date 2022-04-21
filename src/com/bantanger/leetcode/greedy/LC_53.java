package com.bantanger.leetcode.greedy;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/25 11:33
 */
public class LC_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length <= 1) return nums[0];
            int sum = Integer.MIN_VALUE; // 设置系统最小避免出现全为负情况
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i];
                sum = Math.max(sum, count);
                if (count <= 0) count = 0; // 累加的和小于0时将count清空重新累加
            }

            return sum;
        }
    }
}
