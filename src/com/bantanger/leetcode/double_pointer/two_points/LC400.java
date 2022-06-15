package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 17:22
 */
public class LC400 {
    class Solution {
        public int findNthDigit(int n) {
            // 比较难想的点，怎么快速判断给出的n有多少位数字？，如果对个数二分无法找到答案的
            // 对于一个长度（位数）为`len`的数据范围是$$(10^{len - 1}, 10 * len - 1)$$
            //先确定第n位数字到了几位数，每种数字分别占用字符：9*1,90*2，900*3 等等
            int d = 1; // 位数初定为1；
            long num = 9; // 位数为1时有9个数据
            while (n > num * d) {
                n -= num * d; // 对n试减
                d++; // 位数进一
                num *= 10; // 位数进一之后能表示的数据长度是之前的10倍
                // 例如 一开始是个位数，只有0 - 9 个数，数据长度为 10
                // 然后 位数进一是十位数，有10 - 99 个数。数据长度为 100
            }
            // n 一定会大于0，因为while条件是 n > num * d 。也就是 n - num * d > 0 ，
            // 当 n < 0.进不去循环
            int m = (n - 1) / d + 1;
            int p = n - (m - 1) * d; // 求d位数的第m个数的第p位
            int k = (int) (num / 9 + m - 1); // 所求数字所在的那个数
            return (k / (int) Math.pow(10, d - p)) % 10;
        }
    }
}
