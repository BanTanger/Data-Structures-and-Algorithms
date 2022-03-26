package com.bantanger.leetcode.greedy;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/26 17:43
 */
public class LC_55_JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            // 贪心
            int cover = 0;// 覆盖范围
            if (nums.length < 2) return true;
            for (int i = 0; i <= cover; i++) { // i只能走覆盖范围这么多步
                cover = Math.max(i + nums[i], cover); // 当前位置能走的范围和原范围比较，改变的是i能走的上限
                if (cover >= nums.length - 1) return true; // 覆盖范围超过最后下标，返回true
            }
            return false;
        }
    }
}
