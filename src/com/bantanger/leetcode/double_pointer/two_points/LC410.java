package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 18:10
 */
public class LC410 {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            int l = 0, r = 0;
        /*  二分法
        nums = [7,2,5,10,8]
        m = 1，那么整个数组作为一部分，最小的最大值为 32
        m = n，那么每个元素作为一个子数组，从所有元素选取最大值，最小的最大值小为 10
        m 的取值范围为 1 <= m <= n，因此，最大值的最小值的范围为 [10, 32] */
            for (int num : nums) {
                l = Math.max(l, num);
                r += num;
                // 确定左右边界
            }
            int res = 0;
            while (l < r) {
                int cnt = 1; // 一开始尝试从划分一个数组
                int mid = l + (r - l) / 2; // 猜测mid就是答案
                int sum = 0;
                for (int num : nums) {
                    if (sum + num > mid) {
                        sum = 0;
                        cnt++; // 剩余元素溢出，需要再使用一个数组
                    }
                    sum += num; // sum记录当前划分数组的总范围
                }
                if (cnt > m) l = mid + 1; // 需要开辟的数组大于要求，说明猜测小了，需要增大猜测数据
                else r = mid; // 反之
            }
            return l;
        }
    }
}
