package com.bantanger.leetcode.hash;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/22 11:39
 */
public class LC41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int minNum = 1;
            int[] arr = new int[500010]; /* 伪常数级别 */
            // 数据范围会超出nums长度，先把超出范围的全部置为0
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 || nums[i] > nums.length) nums[i] = 0;
                arr[nums[i]] = 1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (arr[minNum] == 1) minNum++; // 如果arr数组中出现过这个数字，就让minNum步进1
            }
            return minNum;
        }
    }
}
