package com.bantanger.leetcode.monotonic_stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/29 9:02
 */
public class LC_42_memory {
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int res = 0;
            // 创建两个备忘录数组代表左右最高柱子
            int[] l_max = new int[n];
            int[] r_max = new int[n];
            // base case 初始化
            l_max[0] = height[0];
            r_max[n - 1] = height[n - 1];
            // 从左计算 i 下标时的最高左柱子
            for (int i = 1; i < n; i++) {
                l_max[i] = Math.max(height[i], l_max[i - 1]);
            }
            // 从右计算 i 下标时的最高右柱子
            for (int i = n - 2; i >= 0; i--) {
                r_max[i] = Math.max(height[i], r_max[i + 1]);
            }
            // 计算结果
            for (int i = 0; i < n - 1; i++) {
                res += Math.min(l_max[i], r_max[i]) - height[i];
            }
            return res;
        }
    }
}
