package com.bantanger.leetcode.binary_heap;

import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/19 15:07
 */
public class LC215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 默认优先级队列是用小顶堆维护的，堆顶是最小元素
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                // 将每一个元素过一遍二叉堆
                pq.offer(num);
                // 堆中元素多于k个时，删除堆顶元素
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            // pq 剩下的就是nums中k个最大的元素
            // 堆顶维护的是最小的那个，即为第k个最大元素
            return pq.peek();
        }
    }
}
