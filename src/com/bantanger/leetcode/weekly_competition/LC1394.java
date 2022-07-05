package com.bantanger.leetcode.weekly_competition;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/5 9:05
 */
public class LC1394 {
    class Solution {
        public int findLucky(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            // 从后往前遍历寻找幸运数字
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.println(map.get(arr[i]));
                if (map.get(arr[i]) == arr[i]) {
                    return arr[i];
                }
            }
            return -1;
        }
    }

    @Test
    public void test() {
        int[] arr = {5, 4, 7, 8, 4, 8, 8, 3, 7, 7, 6, 3, 7, 6, 5, 6, 8, 4, 5, 7, 4, 7, 7, 5, 2, 5, 6, 6, 8, 1, 6, 8, 8, 8, 9, 3, 2, 9};
        new Solution().findLucky(arr);
    }
}
