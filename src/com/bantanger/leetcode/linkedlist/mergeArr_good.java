package com.bantanger.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/21 19:43
 */
public class mergeArr_good {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 一种更为优秀的解法，因为nums1等于两个数组有效数字个数相加，那么可以从后向前遍历
            int i = m - 1, j = n - 1;
            int end = n + m - 1;
            while (j >= 0) {
                nums1[end--] = (i >= 0 && nums1[i] > nums2[j])
                        ? nums1[i--] : nums2[j--];
            }
        }
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int m = 3;
        new Solution().merge(nums1, m, nums2, n);
    }
}
