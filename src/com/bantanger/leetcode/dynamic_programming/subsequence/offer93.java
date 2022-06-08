package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 19:33
 */
public class offer93 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            // 定义dp为记录最后两个斐波那契数的下标，
            // 朴素做法是通过三层for来迭代寻找，但会造成超时
            // 可以通过哈希表来降低一层复杂度
            int n = arr.length;
            int[][] dp = new int[n + 1][n + 1];
            // 创建哈希表记录一层斐波那契数的下标
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    // 如果在map里找不到这个元素就用0标记
                    dp[i][j] = dp[j][map.getOrDefault(arr[i - 1] - arr[j - 1], 0)] + 1;
                    System.out.printf("dp[%d][%d] = %d\n", i, j, dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
                map.put(arr[i - 1], i);
            }
            return ans > 1 ? ans + 1 : 0;
        }
    }
    @Test
    public void test() {
        int[] nums = {1,3,7,11,12,14,18};
        new Solution().lenLongestFibSubseq(nums);
    }
}
