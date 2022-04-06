package com.bantanger.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/6 9:41
 */
public class Two_Dimensional_dp {
    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length, value0 = 0; // 初始化容量为 0 时候的物品价值
        // 定义dp数组，dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        // 初始化，当背包容量为0时，能获得的最大价值为0
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        // 确定遍历顺序，先遍历物品再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                if (j < weight[i - 1]) { // 不能放下这个重量的物品
                    dp[i][j] = dp[i - 1][j];
                } else { // 能放下这个重量的物品
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        // 打印dp数组
        for (int i = 1; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    @Test
    public void test(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
    }
}

