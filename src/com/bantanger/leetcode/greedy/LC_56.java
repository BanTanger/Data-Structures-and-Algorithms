package com.bantanger.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/31 9:56
 */
public class LC_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 按照升序排序
            Arrays.sort(intervals, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            LinkedList<int[]> result = new LinkedList<>();
            result.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                int[] last = result.getLast(); // 获得当前result最后一个元素引用
                if (cur[0] <= last[1]) {
                    last[1] = Math.max(last[1], cur[1]);
                } else {
                    result.add(cur);
                }
            }
            return result.toArray(new int[0][0]);
        }
    }
    @Test
    public void test(){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        new Solution().merge(intervals);
    }
}
