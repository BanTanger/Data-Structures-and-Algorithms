package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/21 15:01
 */
public class LC81 {
    class Solution {
        public boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while(l <= r) {
                int mid = l + r >> 1;
                if(target == nums[mid]) {
                    return true;
                }
                if(nums[mid] == nums[l]) {
                    ++l; // 向左移动一位，排除重复项
                } else if(nums[mid] <= nums[r]) {
                    // 证明右区间[mid, r]有序
                    if(target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    // 证明左区间[l, mid]有序
                    if(target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            return false;
        }
    }
}
