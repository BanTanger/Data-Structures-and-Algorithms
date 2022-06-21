package com.bantanger.leetcode.double_pointer.array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/21 20:31
 */
public class LC80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            // 使用双指针，慢指针一开始就设定在2位置
            // 因为数组有序，并且超过两次出现的元素也只会出现两次
            int start = 2;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[start - 2]) {
                    // 只允许放两个相同的元素，如果超过，就用后一个元素覆盖掉
                    nums[start++] = nums[i];
                }
            }
            return start;
        }
    }
}
