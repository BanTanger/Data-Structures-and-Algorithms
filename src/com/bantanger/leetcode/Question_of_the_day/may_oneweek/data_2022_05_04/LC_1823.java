package com.bantanger.leetcode.Question_of_the_day.may_oneweek.data_2022_05_04;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/4 22:33
 */
public class LC_1823 {
    class Solution {
        public int findTheWinner(int n, int k) {
            int p = 0;
            for(int i = 2; i <= n; i++){
                p = (p + k) % i;
            }
            return p + 1; // 返回的是数组下标，所以需要加一
        }
    }
}
