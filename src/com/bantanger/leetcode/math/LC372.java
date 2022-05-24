package com.bantanger.leetcode.math;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 11:04
 */
public class LC372 {
    class Solution {
        private final int base = 1337;

        public int superPow(int a, int[] b) {
            return superPow(a, b, b.length);
        }

        int i = 1;

        private int superPow(int a, int[] b, int len) {
            if (len == 0) return 1;
            int last = b[len - 1];
            System.out.println("last => " + last);
            len--; // 弹出数组最后一位
            // a ^ (1,2,3,5) =
            //      a ^ (1,2,3)^10 * a ^ 5
            int part1 = myPow(a, last);
            int part2 = myPow(superPow(a, b, len), 10);

            System.out.println("=====" + "第" + (i++) + "层" + "=====");
            System.out.println("part1 => " + part1);
            System.out.println("part2 => " + part2);
            System.out.println("(part1 * part2) % base => " + (part1 * part2) % base);
            return (part1 * part2) % base;
        }

        private int myPow(int a, int k) {
            if (k == 0) return 1;
            // 对因子求模
            a %= base;

            if (k % 2 == 1) {
                // k 是奇数
                System.out.println("    "+"k 是奇数, k = " + k);
                System.out.println("        " + "(a * myPow(a, k - 1)) % base => ");
                System.out.println("            " + " a => " + a + " k => " + k);
                System.out.println("            " + " myPow(a, k - 1)) => " + myPow(a, k - 1));
                System.out.println("                " + " 结果 => " + (a * myPow(a, k - 1)) % base);
                return (a * myPow(a, k - 1)) % base;
            } else {
                // k 是偶数
                int sub = myPow(a, k / 2);
                System.out.println("    "+ "k 是偶数, k = " + k);
                System.out.println("        " + "(sub * sub) % base => ");
                System.out.println("            " + " a => " + a + " k => " + k);
                System.out.println("            " + " sub = myPow(a, k / 2) => " + sub);
                System.out.println("                " + " 结果 => " + (sub * sub) % base);
                return (sub * sub) % base;
            }
        }
    }

    @Test
    public void test() {
        int a = 2;
        int[] b = {1, 0};
        new Solution().superPow(a, b);
    }
}
