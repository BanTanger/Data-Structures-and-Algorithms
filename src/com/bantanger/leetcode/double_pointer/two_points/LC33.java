package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/7 10:11
 */
public class LC33 {
    class Solution {
        public int search(int[] nums, int target) {
            /*
             旋转排序数组，因为一开始是有序数组，所以切分之后，
             两个数组满足关系：一个数组的数全部大于另一个数组的数
             我们假记为num1 >> num2
             使用二分来判断mid 与 nums[nums.length - 1]
             如果 mid 大于，代表 mid 在 num1 中，
             如果 mid 小于，代表 mid 在 num2 中
             我们拿target与nums[0]比较，
             如果大于，说明应该在num1搜索，
             如果小于，说明应该在num2搜索
            */
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + right >> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < nums[right]) {
                    // 应该往 nums1 寻找
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // 应该往 nums2 寻找
                    if (nums[mid] > target && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
