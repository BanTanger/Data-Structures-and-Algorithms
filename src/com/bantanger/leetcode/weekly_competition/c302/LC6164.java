package com.bantanger.leetcode.weekly_competition.c302;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/17 13:48
 */
public class LC6164 {
    class Solution {
        public int maximumSum(int[] nums) {
            int[] clone = nums.clone();
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                while (nums[i] > 0) {
                    sum += nums[i] % 10;
                    nums[i] /= 10;
                }
                // System.out.println(sum);
                map.put(i, sum);
                indexMap.put(sum, i);
            }
            int res = -1;
            for (int i = clone.length - 1; i >= 0; i--) {
                int j = indexMap.get(map.get(i));
                if (j != i) {
                    res = Math.max(res, clone[i] + clone[j]);
                }
            }
            return res;
        }
    }
    @Test
    public void test() {
        String t = "04";
        System.out.println(Integer.parseInt(t));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }
}
