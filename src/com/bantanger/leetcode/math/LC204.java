package com.bantanger.leetcode.math;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 9:25
 */
public class LC204 {
    class Solution {
        public int countPrimes(int n) {
            // 用Sieve of Eratosthenes筛选法
            // 埃拉托色尼筛
            boolean[] isPrime = new boolean[n];
            // 将数组全初始化为true
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    // 筛出所有 i 的倍数
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) count++;
            }
            return count;
        }
    }
}
