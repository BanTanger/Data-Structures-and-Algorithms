package com.bantanger.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/21 19:43
 */
public class mergeArr {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (m == 0 && n == 0) return;
            int k = 0;
            int i = 0, j = 0;
            int[] temp = nums1.clone();
            while (i < m && j < n) {
                temp[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
            }
            while (j < n) {
                temp[k ++] = nums2[j++];
            }
            while (i < m) {
                temp[k ++] = nums1[i++];
            }
            for (int index = 0; index < nums1.length; index++) {
                nums1[index] = temp[index];
            }
        }
    }
    @Test
    public void test() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int n = 3;
        int m = 3;
        new Solution().merge(nums1, m, nums2, n);
    }
}
