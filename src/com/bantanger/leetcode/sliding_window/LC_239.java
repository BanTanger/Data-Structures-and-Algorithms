package com.bantanger.leetcode.sliding_window;

import java.util.LinkedList;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 20:26
 */
public class LC_239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 判空处理
            if (nums == null || nums.length < 2) return nums;
            // 双向队列，维护当前窗口的最大值，
            // 保证队列的数组位置的数是按从大到小来排序的
            LinkedList<Integer> list = new LinkedList<>();
            // 结果数组
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                // 维护最大值单调队列
                while (!list.isEmpty() && nums[list.peekLast()] <= nums[i])
                    list.pollLast();
                // 添加当前值对应的数组下标
                list.add(i);
                // 等到窗口长度达到k，就弹出最左侧的值
                if (list.peek() <= i - k)
                    list.pollFirst();
                // 当窗口元素达到k时，记录当前窗口的最大值
                if (i - k + 1 >= 0) {
                    res[i - k + 1] = nums[list.peekFirst()];
                }
            }
            return res;
        }
    }
}
