package com.bantanger.leetcode.double_pointer.array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/3 9:19
 */
public class LC31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2; // 寻找第一个修改下标
            while (i >= 0 && nums[i] >= nums[i + 1]) i--;
            if (i < 0) {
                reverse(nums, 0, n - 1);
                return;
            }
            int j = n - 1; // 寻找第二哥修改下标
            while (i < j && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
            reverse(nums, i + 1, n - 1); // [i + 1, n - 1]部分升序
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }

        private void reverse(int[] nums, int i, int j) {
            while (i < j) swap(nums, i++, j--);
        }
    }
}
