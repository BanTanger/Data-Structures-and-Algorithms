package com.bantanger.leetcode.weekly_competition.c294;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 22:17
 */
public class LC2280 {
    class Solution {
        public int minimumLines(int[][] stockPrices) {
            Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]); // 对x进行排序
            int n = stockPrices.length, res = 1; // 初始化线段，最少只能有一条线
            if (n == 1) return 0;
            for (int i = 2; i < n; i++) {
                int x1 = stockPrices[i][0] - stockPrices[i - 1][0],
                    y1 = stockPrices[i][1] - stockPrices[i - 1][1];
                int x2 = stockPrices[i - 1][0] - stockPrices[i - 2][0],
                    y2 = stockPrices[i - 1][1] - stockPrices[i - 2][1];
                if (y1 * x2 != y2 * x1) res++;
            }
            return res;
        }
    }
}
