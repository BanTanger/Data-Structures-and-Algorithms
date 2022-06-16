package com.bantanger.leetcode.dynamic_programming.choose;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/16 17:26
 */
public class LC45 {
    class Solution {
        public int jump(int[] nums) {
            // 题目升级，相较于Ⅰ来说，需要找到最少的跳跃次数
            // 怎么寻找呢，实际上这种选择问题dp就派上用场了
            int n = nums.length;
            // 定义dp，dp[i] 中 i表示到达i下标需要的最小步数
            int[] dp = new int[n];
            int baseStartIndex = 0;
            for (int i = 1; i < n; i++) {
                while (i > baseStartIndex + nums[baseStartIndex]) { // 注意这里是while
                    baseStartIndex++; // 这段代码是精华
                }
                dp[i] = dp[baseStartIndex] + 1; // 从baseStartIndex跳到i需要花费的步数
            }
            return dp[n - 1]; // 跳到终点需要的最小步数
        }
    }
}
