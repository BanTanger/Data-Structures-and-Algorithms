package com.bantanger.leetcode.double_pointer.two_points;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/7 11:30
 */
public class LC327 {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            // 试试前缀和先？
            int n = nums.length;
            int[] preSum = new int[n + 1]; // 多创建一个位置。避免讨论
            for (int i = 1; i < n + 1; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            // 我的思路是遍历一遍数组，遍历一遍前缀和，查找符合情况的数字
            int count = 1;
            for (int i = 0; i < n; i++) {
                if (lower <= nums[i] && nums[i] <= upper) {
                    count++;
                }
            }
            count--;
            for (int i = 1; i < n + 1; i++) {
                for (int j = i + 1; j < n + 1; j++) {
                    int diff = preSum[j] - preSum[i];
                    System.out.print(diff + " ");
                    if (lower <= diff && diff <= upper) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    @Test
    public void test() {
        int[] nums = {-2,5,-1,5,0,-7};
        new Solution().countRangeSum(nums, -2, 2);
    }
}
