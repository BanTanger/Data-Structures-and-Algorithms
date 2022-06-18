package com.bantanger.leetcode.difference_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/18 9:53
 */
public class LC73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            HashMap<Integer, int[]> map = new HashMap<>(); // 记录下标值
            int n = matrix.length, m = matrix[0].length;
            int[] arr = new int[2];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (matrix[i][j] == 0) {
                        arr[0] = i;
                        arr[1] = j;
                        map.put(0, arr);
                    }
            int[] ints = map.get(0);
            int anInt = ints[0]; // 行元素初始化为0
            int anInt1 = ints[1]; // 列元素初始化为0
            for(int j = 0; j < m; j++) {
                matrix[anInt][j] = 0;
            }
            for(int i = 0; i < n; i++) {
                matrix[i][anInt1] = 0;
            }
        }
    }
    
    @Test
    public void test() {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Solution().setZeroes(matrix);
    }
}
