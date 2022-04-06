package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/6 10:14
 */
public class LC_416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums.length <= 1 || nums == null) return false;
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 当总和为奇数时不允许分割
            if (sum % 2 != 0) return false;
            // 总和为偶数时分割成两个背包
            int target = sum >> 1;
            int[] dp = new int[target + 1];
            for (int i = 0; i < n; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            return dp[target] == target; // 查看dp最后位置（结果）是否等于分割大小
        }
    }
}
