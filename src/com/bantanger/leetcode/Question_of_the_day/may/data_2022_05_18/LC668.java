package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_18;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 13:00
 */
public class LC668 {
    class Solution {
        int n, m, k;

        /*
        因为是顺序矩阵，所以可以不拿出具体数据，我们只要知道mid前面的肯定比mid小，mid后面的肯定都比mid大即可
         */
        public int findKthNumber(int _m, int _n, int _k) {
            m = Math.max(_m, _n);
            n = Math.min(_m, _n);
            k = _k;
            int l = 1, r = m * n;
            while (l < r) {
                int mid = l + r >> 1;
                int cnt = getCnt(mid);
                if (cnt >= k) r = mid;
                else l = mid + 1;
            }
            return r;
        }

        /*
        a 表示比k小的数，b 表示等于k的数 cnt = a + b;
         */
        private int getCnt(int mid) {
            int a = 0, b = 0;
            for (int i = 1; i <= n; i++) {
                if (i * m < mid) a += m;
                else {
                    if (mid % i == 0) {
                        // i * m = mid
                        a += mid / i - 1; // i * m 以前的数据都小于mid
                        b++; // 当前i * m == mid， b进位
                    } else {
                        // i * m > mid
                        a += mid / i;
                    }
                }
            }
            return a + b;
        }
    }
}
