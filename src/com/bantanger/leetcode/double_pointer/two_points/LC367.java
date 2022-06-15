package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 22:18
 */
public class LC367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            long l = 1, r = num;
            /* l 必须取1， 不然当num = 1 时， mid = 0，t = num / mid出现除法异常*/
            while (l <= r) {
                long mid = l + (r - l) / 2;
                // if(mid * mid == num) return true; 会爆掉，java没有longlong
                long t = num / mid; // 逆向思考，如果t == mid，证明mid就是num的平方根
                if (t == mid) { // 有可能向下取整了，再对num膜一次
                    if (num % mid == 0) return true;
                    l = mid + 1; // 如果走到这一步，说明猜的mid小了，除法向下取整。
                } else if (mid * mid < num) {
                    l = mid + 1; // 猜小了
                } else {
                    r = mid - 1;
                }
            }
            return false;
        }
    }
}
