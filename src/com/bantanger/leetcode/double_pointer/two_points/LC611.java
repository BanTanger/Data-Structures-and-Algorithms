package com.bantanger.leetcode.double_pointer.two_points;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/16 8:54
 */
public class LC611 {
    class Solution {
        public int triangleNumber(int[] nums) {
            // O(n2)，将第三层和第二层循环合并
            Arrays.sort(nums);
            int res = 0;
            int n = nums.length;
            for (int i = n - 1; i >= 0; i--) {
                int k = 0, j = i - 1;
                while (k < j) {
                    if (nums[k] + nums[j] > nums[i]) {
                        // 排列过后，如果满足这个条件，
                        // 代表从nums[k] 到nums[j]的所有数都满足要求，
                        // 结果直接加上 j - k
                        res += j - k;
                        j--;
                    } else {
                        // k自增，重新判断
                        k++;
                    }
                }
            }
            return res;
        }
    }
}
