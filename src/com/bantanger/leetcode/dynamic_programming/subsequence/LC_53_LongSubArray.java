package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/21 10:13
 */
public class LC_53_LongSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = nums[0];
            int res = dp[0];
            for(int i = 1; i < nums.length; i++){
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            for(int x : dp){
                res = Math.max(x, res);
            }
            return res;
        }
    }

    @Test
    public void test(){
        int[] dp = {-1};
        new Solution().maxSubArray(dp);
        new Solution2().maxSubArray(dp);
    }
}
