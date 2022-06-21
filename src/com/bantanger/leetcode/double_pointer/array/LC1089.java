package com.bantanger.leetcode.double_pointer.array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/17 9:17
 */
public class LC1089 {
    class Solution {
        public void duplicateZeros(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == 0) {
                    int j = n - 1;
                    // 发现慢指针指向零，就令快指针从尾到头向后覆盖一格
                    while (j > i + 1) {
                        arr[j] = arr[j - 1];
                        // System.out.printf("arr[%d]=%d ", j, arr[j]);
                        j--;
                    }
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }
}
