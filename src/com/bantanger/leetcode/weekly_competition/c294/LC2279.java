package com.bantanger.leetcode.weekly_competition.c294;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 22:18
 */
public class LC2279 {
    class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int n = capacity.length;
            int[] left = new int[n];
            for (int i = 0; i < n; i++) left[i] = capacity[i] - rocks[i]; // 先算出差分
            Arrays.sort(left); // 然后对差分排序
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (left[i] == 0) ans++;
                else if (additionalRocks >= left[i]) {
                    additionalRocks -= left[i];
                    ans++;
                }
            }
            return ans;
        }
    }
}
