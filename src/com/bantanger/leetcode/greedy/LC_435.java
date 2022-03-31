package com.bantanger.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/31 7:49
 */
public class LC_435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            // 对end排序
            Arrays.sort(intervals, (o1, o2) -> {
                return o1[1] - o2[1];
            });
            int end = intervals[0][1];
            int result = -1; // 增强for一开始会先读取无用位置一，所以把result置-1来抹去干扰
            for (int[] interval : intervals) {
                int start = interval[0];
                if (start >= end) {
                    end = interval[1];
                } else {
                    result++;
                }
            }
            return result;
        }
    }
    @Test
    public void test(){
        int[][] intervals =  {{1,2}, {2,3}, {3,4}, {1,3}};
        new Solution().eraseOverlapIntervals(intervals);
    }
}
