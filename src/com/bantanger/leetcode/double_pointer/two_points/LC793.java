package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 9:01
 */
public class LC793 {
    class Solution {
        public int preimageSizeFZF(int k) {
            // 使用二分，在区间[0, LONG_MAX]里寻找满足题意的左侧边界和右侧边界
            return (int) (rightBound(k) - leftBound(k) + 1);
        }

        public long trailingZeroes(long n) {
            // 阶乘不要算出来，要算末尾有几个零，只需要找有多少个因子5就行了，因为5 * 2
            // 而所有偶数都能拆成2，所以不用担心2不够用。
            // 防止溢出，使用long
            long res = 0;
            for (long d = n; d / 5 > 0; d /= 5) {
                res += d / 5;
            }
            return res;
        }

        // 使用二分查找目标区间的左边界
        private long leftBound(int k) {
            long l = 0, r = Long.MAX_VALUE;
            while (l < r) {
                long mid = l + r >> 1;
                if (trailingZeroes(mid) < k) {
                    l = mid + 1;
                } else if (trailingZeroes(mid) > k) {
                    r = mid;
                } else {
                    r = mid; // 找到目标元素，缩小左边界
                }
            }

            return l;
        }

        // 使用二分查找目标区间的右边界
        private long rightBound(int k) {
            long l = 0, r = Long.MAX_VALUE;
            while (l < r) {
                long mid = l + r >> 1;
                if (trailingZeroes(mid) < k) {
                    l = mid + 1;
                } else if (trailingZeroes(mid) > k) {
                    r = mid;
                } else {
                    l = mid + 1; // 找到目标元素，缩小右边界
                }
            }

            return r - 1;
        }
    }
}
