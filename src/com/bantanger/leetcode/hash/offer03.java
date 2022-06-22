package com.bantanger.leetcode.hash;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/22 12:07
 */
public class offer03 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            // 与Lc41一致的思路。建立相应的映射
            // 在本题中因为数据量被封闭在[0, n - 1]
            // 所以建立的映射应该是 i = nums[i]
            int i = 0;
            while (i < nums.length) {
                if (nums[i] == i) {
                    i++;
                    continue;
                }
                if (nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }
    }
}
