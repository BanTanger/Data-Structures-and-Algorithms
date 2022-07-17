package com.bantanger.leetcode.weekly_competition.c302;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/17 20:03
 */
public class LC6121 {
    class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] res = new int[queries.length];
            int index = 0;
            for (int[] querie : queries) {
                for (int i = 0; i < nums.length; i++) {
                    int num = Integer.parseInt(nums[i].substring(nums[i].length() - querie[1]));
                    if (pq.size() <= querie[0]) {
                        Node p = new Node();
                        p.val = num;
                        p.index = i;
                        pq.offer(p);
                    }
                }
                res[index++] = pq.poll().index;
            }
            return res;
        }
    }

    class Node {
        public int val;
        public int index;
    }

    @Test
    public void test() {
        String[] q = {"102","473","251","814"};
        int[][] num = {{1,1},{2,3},{4,2},{1,2}};
        new Solution().smallestTrimmedNumbers(q, num);
    }
}
