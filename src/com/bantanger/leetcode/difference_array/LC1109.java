package com.bantanger.leetcode.difference_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 9:19
 */
public class LC1109 {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            DifferenceArray df = new DifferenceArray(n);
            for (int[] nums : bookings) {
                df.increment(nums);
            }
            return df.result(n);
        }
    }

    class DifferenceArray {
        private int[] diff;
        private int[] res;

        public DifferenceArray(int len) {
            diff = new int[len];
        }

        public void increment(int[] nums) {
            // 注意转换成差分数组索引要减一，因为题目给的数组是从1开始的
            diff[nums[0] - 1] += nums[2];
            if (nums[1] < diff.length) {
                diff[nums[1]] -= nums[2];
            }
        }

        public int[] result(int n) {
            res = new int[n];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = diff[i] + res[i - 1];
            }
            return res;
        }
    }
}
