package com.bantanger.leetcode.sort.quick_choose;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/4 10:11
 */
public class LC215 {
    class Solution {
        /*
        *   执行用时：8 ms, 在所有 Java 提交中击败了31.00%的用户
            内存消耗：41.4 MB, 在所有 Java 提交中击败了62.36%的用户
            * 这题还是用堆来做好，又方便又简单
        * */
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            return quickSort(nums, 0, n - 1, n - k + 1);
        }

        private int quickSort(int[] nums, int l, int r, int k) {
            if (l == r) return nums[l];
            int x = nums[l], i = l - 1, j = r + 1;
            while (i < j) {
                while (nums[++i] < x) ;
                while (nums[--j] > x) ;
                if (i < j) {
                    nums[i] ^= nums[j];
                    nums[j] ^= nums[i];
                    nums[i] ^= nums[j];
                }
            }
            int sL = j - l + 1;
            if (k <= sL) return quickSort(nums, l, j, k);
            return quickSort(nums, j + 1, r, k - sL);
        }
    }
}
