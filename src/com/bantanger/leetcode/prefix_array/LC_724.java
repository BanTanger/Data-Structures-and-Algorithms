package com.bantanger.leetcode.prefix_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 12:54
 */
public class LC_724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            // 使用前缀和 和 后缀和技巧
            int n = nums.length;
            int[] prefix = new int[n + 1];
            int[] suffix = new int[n + 1];
            for (int i = 1, j = n - 2; i <= n && j >= 0; i++, j--) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
                suffix[j] = suffix[j + 1] + nums[j + 1];
                // System.out.println(prefix[i] + " " + suffix[j]);
            }
            for (int i = 0; i < n; i++) {
                if (prefix[i] == suffix[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
