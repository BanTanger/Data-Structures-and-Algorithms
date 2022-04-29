package com.bantanger.leetcode.monotonic_stack;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/29 8:25
 */
public class LC_503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            // 模拟数组长度翻倍
            for (int i = 2 * n - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                    s.pop(); // 矮子滚粗克
                }
                res[i % n] = s.isEmpty() ? -1 : s.peek();
                s.add(nums[i % n]);
            }
            return res;
        }
    }
}
