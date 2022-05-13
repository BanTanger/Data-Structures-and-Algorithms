package com.bantanger.leetcode.difference_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 9:45
 */
public class LC1094 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            // 差分数组，乘客数看成val，只要 val > capacity 没法搭人
            Difference df = new Difference();
            for (int[] nums : trips) {
                df.increment(nums);
            }
            int[] num = df.result();
            for (int n : num) {
                if (n > capacity) return false;
            }
            return true;
        }
    }

    class Difference {
        private int[] diff;
        private int[] res;

        public Difference() {
            diff = new int[1001];
        }

        public void increment(int[] nums) {
            int i = nums[1];
            int j = nums[2] - 1;
            int val = nums[0];
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            res = new int[1001];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = diff[i] + res[i - 1];
            }
            return res;
        }
    }
}
