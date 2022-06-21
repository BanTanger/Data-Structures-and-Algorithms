package com.bantanger.leetcode.double_pointer.array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 23:04
 */
public class LC_167_towSumⅡ {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            // 有二分查找的思想
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else if (sum == target) {
                    return new int[]{left + 1, right + 1};
                    // 为什么要加一？
                    // 因为返回的下标要求从1开始，而根据数组定义下标从0开始
                }
            }
            return new int[]{-1, -1};
        }
    }
}
