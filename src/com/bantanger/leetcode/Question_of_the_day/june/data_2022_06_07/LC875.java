package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_07;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/7 9:33
 */
public class LC875 {
    class Solution {
        /*对速度进行二分查找*/
        public int minEatingSpeed(int[] piles, int h) {
            Arrays.sort(piles); /*先进行排序，总而二分一个中间平均速度*/
            int n = piles.length;
            int left = 1, right = piles[n - 1]; /*分别代表最小速度和最大速度*/
            while (left < right) {
                int mid = left + right >> 1;
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (piles[i] <= mid) { /* 当前速度大于香蕉数，小时数加一 */
                        count++;
                    } else { /*当前速度小于香蕉数，香蕉能否被整除，
                    如果能，小时数就加上吃完香蕉用时
                    如果不能，代表还有余数，小时数再进一*/
                        count +=
                            piles[i] % mid == 0
                                    ? piles[i] / mid /*能整除*/
                                    : piles[i] / mid + 1; /*有余数*/
                    }
                    if(count > h) break; /*提前终止结果*/
                }
                if (count > h) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
