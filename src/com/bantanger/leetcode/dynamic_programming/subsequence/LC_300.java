package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/18 9:38
 */
public class LC_300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1); // 填充数组的操作
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    // 寻找从 [0,i)范围内比nums[i]小的数据
                    // 如果不符合条件，dp[i]还是dp[i]，也就是延续上一次dp[i]的值
                    if (nums[i] > nums[j])
                        dp[i] = dp[j] + 1;
                }
                for(int k = 0; k < nums.length; k++){
                    System.out.print(dp[k] + " ");
                }
                System.out.println();
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
                // 这里需要设置res来比较，因为最长子序列不一定就在最后
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] dp = {1,2,4,5,4};
        new Solution().lengthOfLIS(dp);
    }
}
