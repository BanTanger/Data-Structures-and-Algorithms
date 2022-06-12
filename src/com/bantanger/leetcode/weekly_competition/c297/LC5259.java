package com.bantanger.leetcode.weekly_competition.c297;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/12 10:56
 */
public class LC5259 {
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double res = 0;
            if(income < brackets[0][0]) {
                res += income * 0.01 * brackets[0][1];
                return res;
            } else {
                res += brackets[0][0] * 0.01 * brackets[0][1];
            }
            for(int i = 1; i < brackets.length; i++) {
                if(income > brackets[i][0]) {
                    res += (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] * 0.01;
                } else {
                    res += (income - brackets[i - 1][0]) * brackets[i][1] * 0.01;
                    break;
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
//        int[][] nums = {{3,50},{7,10},{12,25}};
//        int[][] nums = {{1,0},{4, 25},{5,50}};
        int[][] nums = {{4,8}, {5,49}};
        System.out.println(new Solution().calculateTax(nums, 2));
    }
}
