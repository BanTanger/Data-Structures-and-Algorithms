package com.bantanger.leetcode.weekly_competition.c77;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/27 16:37
 */
public class LC2256 {
    class Solution {
        public int minimumAverageDifference(int[] nums) {
            // 长度为10^5 数据最大为10^5，
            // 所以二者相乘 10^5 * 10^5 超过int的范围，所以要使用long
            long preSum[] = new long[nums.length + 1];
            // 前缀和数组向后挪一位，preSum[0] = 0，这样能统一后面的区间减法
            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            int ans = -1;
            long average = (long) 1e12;
            for (int i = 1; i <= nums.length; i++) {
                long d = Math.abs(segAverage(preSum, 0, i)
                        - segAverage(preSum, i, nums.length));
                if (d < average) {
                    ans = i - 1; // 避免出现[0,0,0] 返回1的尴尬
                    average = d;
                }
            }
            return ans;
        }

        public long segAverage(long preSum[], int l, int r) {
            return l == r ? 0 : (preSum[r] - preSum[l]) / (r - l);
        }
    }
}
