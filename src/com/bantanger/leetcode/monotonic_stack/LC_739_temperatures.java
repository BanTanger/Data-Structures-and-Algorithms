package com.bantanger.leetcode.monotonic_stack;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/27 13:47
 */
public class LC_739_temperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            // 单调递增栈,里面加入的元素是数组下标，维护一个递增的下标排列
            Stack<Integer> stack = new Stack<>();
            int len = temperatures.length;
            int[] res = new int[len];

            stack.push(0);
            for (int i = 1; i < len; i++) {
                // 三情况分析，小于大于等于
                if (temperatures[i] <= temperatures[stack.peek()])
                    stack.push(i);
                else {
                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        res[stack.peek()] = i - stack.peek();
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
            return res;
        }
    }

    /*稍微精简的代码*/
    class Solution2 {
        public int[] dailyTemperatures(int[] temperatures) {
            // 单调递增栈,里面加入的元素是数组下标
            Stack<Integer> stack = new Stack<>();
            int len = temperatures.length;
            int[] res = new int[len];

            stack.push(0);
            for (int i = 1; i < len; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return res;
        }
    }
}
