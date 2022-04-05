package com.bantanger.leetcode.Question_of_the_day;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/5 9:08
 */
public class LC_762_2022_04_05 {
    class Solution {
        public int countPrimeSetBits(int left, int right) {
            // 暴力枚举
            int ans = 0;
            for (int i = left; i <= right; i++) {
                int num = Integer.bitCount(i);
                if (isPrime(num)) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        }
    }
}
