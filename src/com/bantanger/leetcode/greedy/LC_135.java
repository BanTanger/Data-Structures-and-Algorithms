package com.bantanger.leetcode.greedy;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/28 19:07
 */
public class LC_135 {
    class Solution {
        public int candy(int[] ratings) {
            int[] candyVec = new int[ratings.length];
            candyVec[0] = 1;
            // 从前往后遍历贪心，只看评分高的右孩子
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candyVec[i] = candyVec[i - 1] + 1;
                } else {
                    candyVec[i] = 1;
                }
            }
            // 从后往前遍历贪心，只看评分高的左孩子
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
                }
            }
            int result = 0;
            for (int s : candyVec) {
                result += s;
            }
            return result;
        }
    }
}
