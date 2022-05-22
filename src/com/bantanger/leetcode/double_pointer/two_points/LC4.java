package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 8:36
 */
public class LC4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            // 为了复用代码，确保总长度为奇数和总长度为偶数时得到中位数的算法一致，减少代码冗余。
            int left = (m + n + 1) / 2;
            int right = (m + n + 2) / 2;
            return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
        }

        public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
            // 如果有一个数组已经全部被淘汰，那么自然直接去另一个数组寻找，返回结果就好。
            if (i >= nums1.length) return nums2[j + k - 1];
            if (j >= nums2.length) return nums1[i + k - 1];
            // 如果此时到了胶着状态——k==1（也就是想要第一位元素作为结果返回），那么就直接可以从 nums1 和 nums2 中拿到最小的值作为结果返回了。
            if (k == 1) return Math.min(nums1[i], nums2[j]);
            // 如果有一方的数组长度<K/2,那么舍弃另一个数组的 K/2 个元素，就是这里赋最大值的意义，可以在之后的 if(midVal1<midVal2) 判断中发挥作用。
            int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
            int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
            // 将比较值较小的一方淘汰掉 K/2 个数组元素。上文中如果赋最大值也在这里起作用
            if (midVal1 < midVal2) {
                // 递归调用，直到可以得到结果
                return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
            } else {
                // 递归调用，直到可以得到结果
                return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
            }
        }
    }
}
