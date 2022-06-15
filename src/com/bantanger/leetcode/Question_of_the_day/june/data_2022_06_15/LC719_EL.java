package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_15;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 11:04
 */
public class LC719_EL {
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            // 优先级队列维护第k小
            PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    q.offer(nums[i] - nums[j]);
                    if(q.size() > k) {
                        q.poll();
                    }
                }
            }
            for(int i = 0; i < q.size(); i++) {
                System.out.println(q.peek());
            }
            return q.poll();
        }
    }
    @Test
    public void test() {
        int[] nums = {1,3,1};
        new Solution().smallestDistancePair(nums,1);
    }
}
