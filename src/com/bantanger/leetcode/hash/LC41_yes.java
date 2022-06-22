package com.bantanger.leetcode.hash;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/22 11:39
 */
public class LC41_yes {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 原地哈希，从题目中可以看出缺失正数必然会出现在[1, len - 1]中
            // 我们构建一个 数据 1 --> 下标 0 的映射。如果有映射不满足这个关系，直接返回这个下标
            // 映射关系为 i == nums[i] - 1;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
            }
            for (int i = 0; i < len; i++) {
                if (i != nums[i] - 1) return i + 1;
            }
            return len + 1;
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
