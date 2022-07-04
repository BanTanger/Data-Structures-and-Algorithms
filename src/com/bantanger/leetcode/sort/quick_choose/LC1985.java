package com.bantanger.leetcode.sort.quick_choose;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;


/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/4 9:46
 */
public class LC1985 {
    class Solution {
        public String kthLargestNumber(String[] nums, int k) {
            int n = nums.length;
            int k_min = n - k; // 把第k大转换成第k小
            // 快速选择排序
            return quickSort(nums, 0, n - 1, k_min);

        }

        private String quickSort(String[] nums, int l, int r, int k) {
            if (l == r) return nums[l];
            String x = nums[l];
            int i = l - 1, j = r + 1;
            while (i < j) {
                System.out.println(nums[i + 1].compareTo(x));
                while (nums[++i].compareTo(x) <= 0)
                while (nums[--j].compareTo(x) >= 0)
                    System.out.println(nums[j].compareTo(x));
                if (i < j) {
                    String temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            int sL = j - l + 1;
            if (k <= sL) return quickSort(nums, l, j, k);
            return quickSort(nums, j + 1, r, k - sL);
        }
    }

    @Test
    public void test(){
        String[] nums = {"2","21","12","1"};
        int k = 3;
        new Solution().kthLargestNumber(nums, k);
    }
}
