package com.bantanger.leetcode.greedy;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/26 22:07
 */
public class LC_45_JumpGameⅡ {
    class Solution {
        public int jump(int[] nums) {
            int covernext = 0;
            int covercur = 0;
            int num = 0;
            for (int i = 0; i <= covercur && covercur < nums.length - 1; i++) {
                covernext = Math.max(covernext, i + nums[i]);
                if (i == covercur) {
                    covercur = covernext;
                    num++;
                }
            }
            return num;
        }
    }
}
