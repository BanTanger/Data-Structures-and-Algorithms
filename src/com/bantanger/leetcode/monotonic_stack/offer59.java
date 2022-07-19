package com.bantanger.leetcode.monotonic_stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/19 12:49
 */
public class offer59 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null && nums.length < 1) return nums;
            LinkedList<Integer> list = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                // 维护最大值的单调栈
                while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) list.pollLast();
                list.add(i); // 添加元素下标（当前一定是最大值）
                if (list.peek() <= i - k) list.pollFirst();
                System.out.println("peek=" + list.peek());
                System.out.println("peekLast=" + list.peekLast());
                System.out.println("peekFirst=" + list.peekFirst());
                if (i - k + 1 >= 0)
                    res[i - k + 1] = nums[list.peekFirst()];
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        new Solution().maxSlidingWindow(nums, k);
    }
}
