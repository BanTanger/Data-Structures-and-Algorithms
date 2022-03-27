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
                // covercur最大范围是nums.length - 2
                covernext = Math.max(covernext, i + nums[i]);
                if (i == covercur) {
                    covercur = covernext;
                    num++;
                }
                // 当移动下标指向了nums.length - 2时
                // 如果移动下标等于当前覆盖最大距离下标，需要再走一步，num++
                // 如果移动下标不等于当前覆盖最大距离下标，说明最远覆盖距离可以覆盖终点，因此不用再走一步
            }
            return num;
        }
    }
}
