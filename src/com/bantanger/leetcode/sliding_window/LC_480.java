package com.bantanger.leetcode.sliding_window;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 20:49
 */
public class LC_480 {
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            // 朴素做法，对每一个滑动窗口的元素进行一次排序，取出中位数
            int n = nums.length;
            int len = n - k + 1; // 窗口滑动范围
            double[] res = new double[len]; // 一共能产生出来的结果
            int[] t = new int[k]; // 窗口数组
            for (int l = 0, r = l + k - 1; r < n; l++, r++) {
                // 对当前窗口的所有元素进行排序
                for (int i = l; i <= r; i++) t[i - l] = nums[i];
                Arrays.sort(t);
                res[l] = (t[k / 2] / 2.0) + (t[(k - 1) / 2] / 2.0);
            }
            return res;
        }
    }
}
