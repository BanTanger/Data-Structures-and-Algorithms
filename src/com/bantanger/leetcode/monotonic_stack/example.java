package com.bantanger.leetcode.monotonic_stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 14:35
 */
public class example {
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的 next great number
            res[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums = {2,1,2,4,3};
        nextGreaterElement(nums);
    }
}
