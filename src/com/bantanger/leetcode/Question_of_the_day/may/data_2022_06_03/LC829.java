package com.bantanger.leetcode.Question_of_the_day.may.data_2022_06_03;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/3 11:47
 */
public class LC829 {
    class Solution {
        int res = 1;
        Queue<Integer> q = new LinkedList<>();
        public int consecutiveNumbersSum(int n) {
            // 连续整数：回溯
            helper(n, 0, 0);
            return res;
        }
        private void helper(int target, int sum, int startIndex) {
            if(sum == target) {
                res++;
                return ;
            }
            if(sum > target) {
                q.poll();
                return ;
            }
            for(int i = 1; i < target / 2; i++) {
                q.offer(i);
                sum += q.peek();
                helper(target, sum, i + 1);
                sum -= q.peek();
            }
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().consecutiveNumbersSum(15));
    }
}
