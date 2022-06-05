package com.bantanger.leetcode.weekly_competition.c296;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/5 23:19
 */
public class LC6900 {
    class Solution {
        public int minMaxGame(int[] nums) {
            while (true) {
                int n = nums.length;
                if (n == 1) break;
                int[] newNums = new int[n / 2];
                for (int i = 0; i < n / 2; i++) {
                    // 偶数
                    if (i % 2 == 0) {
                        newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    } else {
                        newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                    }
                }
                nums = Arrays.copyOf(newNums, n / 2);
            }
            return nums[0];
        }
    }
}
