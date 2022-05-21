package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/21 16:31
 */
public class LC540 {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            // 二分，找偶数下标
            // 分析，因为只能由一个单独数，并且为有序数组
            // 所以，如果是两个数，在没有单独数破坏下标的前提下
            // 第一个数下标一定为偶数，第二个数下标一定为奇数。
            // 如果是一个数的话，下标一定为偶数
            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (mid % 2 == 0) {
                    // 下标为偶数的情况
                    if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                        // 说明[l, mid]没有单独数插入
                        l = mid + 1;
                    } else {
                        // 单独数在[l, mid]中
                        r = mid;
                    }
                } else {
                    // 下标为奇数的情况。
                    if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
            }
            return nums[r];
        }
    }
}
