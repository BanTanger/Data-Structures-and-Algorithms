package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_19;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 13:00
 */
public class LC462 {
    class Solution {
        public int minMoves2(int[] nums) {
            // 感觉用 dp 来做
            // 没想到是贪心，找到中位数就是最优解
            // 题解参考:https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solution/by-fuxuemingzhu-13z3/
            Arrays.sort(nums);
            int l = 0, r = nums.length - 1, res = 0;
            while (l < r) {
                res += nums[r--] - nums[l++];
            }
            return res;
        }
    }
}
