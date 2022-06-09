package com.bantanger.leetcode.dynamic_programming.subarray;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 16:16
 */
public class LC718 {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int res = 0;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (nums1[i - 1] == nums2[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        new Solution().findLength(nums1, nums2);
    }
}
