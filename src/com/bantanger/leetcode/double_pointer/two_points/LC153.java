package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/21 15:41
 */
public class LC153 {
    class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < nums[r]) {
                    // nums[mid] 一定在nums2里，那么此时 l < i <= mid;
                    r = mid;
                } else {
                    // nums[mid] 一定在nums1里，那么此时 mid < i <= r
                    l = mid + 1;
                }
            }
            return nums[l];
        }
    }
}
