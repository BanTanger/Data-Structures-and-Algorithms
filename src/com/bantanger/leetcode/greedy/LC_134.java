package com.bantanger.leetcode.greedy;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/27 10:08
 */
public class LC_134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curSum = 0;
            int totalSum = 0;
            int index = 0;
            for (int i = 0; i < gas.length; i++) {
                curSum += gas[i] - cost[i];
                totalSum += gas[i] - cost[i];
                if (curSum < 0) {
                    index = (i + 1) % gas.length;
                    curSum = 0;
                }
            }
            if (totalSum < 0) return -1;
            return index;
        }
    }
}
