package com.bantanger.leetcode.double_pointer.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/3 9:19
 */
public class LC556 {
    class Solution {
        List<Integer> digits = new ArrayList<>();

        public int nextGreaterElement(int n) {
            while (n > 0) {
                digits.add(n % 10);
                n /= 10;
            }
            Collections.reverse(digits);
            // 问题转化成leetcode31.下一个排列
            // 找到第一个交换的节点
            int i = digits.size() - 2;
            while (i >= 0 && digits.get(i) >= digits.get(i + 1)) i--;
            if (i < 0) return -1; // 如果i小于零，代表这个n是两位数，且找不到比他大的排列
            // 找到第二个交换的节点
            int j = digits.size() - 1;
            while (i < j && digits.get(j) <= digits.get(i)) j--;
            swap(i, j); // 此时j下标的元素比i下标大
            reverse(i + 1, digits.size() - 1);
            long ans = 0L;
            for (int digit : digits) {
                ans = ans * 10 + digit;
            }
            return ans > Integer.MAX_VALUE ? -1 : (int) ans;
        }

        private void reverse(int left, int right) {
            while (left < right) swap(left++, right--);
        }

        private void swap(int left, int right) {
            int temp = digits.get(left);
            digits.set(left, digits.get(right));
            digits.set(right, temp);
        }
    }
}
