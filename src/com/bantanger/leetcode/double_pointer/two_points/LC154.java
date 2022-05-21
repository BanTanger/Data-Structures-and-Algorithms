package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/21 15:35
 */
public class LC154 {
    class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < nums[r]) {
                    // nums[mid] 在 nums2里，分界点i 所在区间为 l < i <= mid
                    r = mid;
                } else if (nums[mid] > nums[r]) {
                    // nums[mid] 在 nums1里，分界点i 所在区间为 mid < i <= r
                    l = mid + 1;
                } else {
                    // 如果 nums[mid] == nums[r]
                    // 没法判断分界点在左边还是右边
                    // 这里r自减，根据前面的讨论不会丢失最小值
                    r--;
                }
            }
            return nums[l];
        }
    }
}
