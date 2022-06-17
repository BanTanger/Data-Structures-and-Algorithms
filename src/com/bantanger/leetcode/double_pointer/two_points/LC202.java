package com.bantanger.leetcode.double_pointer.two_points;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/17 17:02
 */
public class LC202 {
    class Solution {
        int[] hashmap;
        public boolean isHappy(int n) {
            // 一共有0 - 9这十个数，我们直接把各自的平方和计算出即可
            // HashMap<Integer, Integer> map = new HashMap<>();
            hashmap = new int[10];
            for (int i = 0; i < hashmap.length; i++) {
                hashmap[i] = i * i;
            }
            // 把数字转换成String
            int fast = n, slow = n;
            do {
                /* 双指针检测是否成环 */
                slow = helper(slow);
                fast = helper(fast);
                fast = helper(fast);
            } while (slow != fast); /*跳出循环时即找到环入口*/
            if (fast == 1) return true;
            return false;
        }

        private int helper(int num) {
            String str = num + "";
            num = 0;
            for (int i = 0; i < str.length(); i++) {
                num += hashmap[str.charAt(i) - '0'];
            }
            return num;
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().isHappy(Integer.MAX_VALUE));
    }
}
