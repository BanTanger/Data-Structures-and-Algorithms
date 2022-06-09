package com.bantanger.leetcode.sliding_window;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 19:36
 */
public class LC_1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            // 转换思路，把寻找转换后的最长子数组看成寻找最长子数组，它内部最多有2个零
            // 滑动窗口，限制窗口最多只能有两个零，如果超过了就被动移动窗口
            int zero = 0;
            int ans = 0;
            int l = 0, r = 0;
            while (r < nums.length) {
                if (nums[r] == 0) {
                    zero++;
                }
                while (zero > k && l < nums.length) { // 不满足滑动窗口限制条件，左移窗口直到符合
                    if (nums[l] == 0) {
                        zero--;
                    }
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
                // 窗口右扩
                r++;
            }
            return ans;
        }
    }
}
