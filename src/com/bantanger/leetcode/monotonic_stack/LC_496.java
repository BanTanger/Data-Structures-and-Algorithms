package com.bantanger.leetcode.monotonic_stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 9:12
 */
public class LC_496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            int n = nums1.length;
            int m = nums2.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            // 哈希map做映射，通过数值快速锁定下标
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hashmap.put(nums1[i], i);
            }
            stack.add(0);
            for (int i = 1; i < m; i++) {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    if (hashmap.containsKey(nums2[stack.peek()])) {
                        Integer index = hashmap.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.add(i);
            }
            return res;
        }
    }
}
