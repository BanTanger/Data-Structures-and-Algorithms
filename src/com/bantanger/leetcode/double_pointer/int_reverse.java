package com.bantanger.leetcode.double_pointer;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/21 17:28
 */
public class int_reverse {
    class Solution {
        public int reverse(int x) {
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            return (int) res == res ? (int) res : 0;
        }
    }

    @Test
    public void test() {
        new Solution().reverse(123);
    }
}
