package com.bantanger.leetcode.Question_of_the_day.july.data_2022_7_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/4 7:40
 */
public class LC1200 {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            int diff = Integer.MAX_VALUE;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                diff = Math.min(arr[i] - arr[i - 1], diff);
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] == diff) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i - 1]);
                    temp.add(arr[i]);
                    res.add(temp);
                }
            }
            return res;
        }
    }
}
