package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_442 {
    class Solution_Rebellion {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int n = nums.length;
            for (int num : nums) {
                if (nums[Math.abs(num) - 1] < 0) { // 出现不止一次
                    res.add(Math.abs(num));
                } else {
                    nums[Math.abs(num) - 1] *= -1;
                }
            }
            return res;
        }
    }

    class Solution_offset {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                if (nums[(num % 100000) - 1] > 100000) {
                    res.add(num % 100000);
                } else {
                    nums[(num % 100000) - 1] += 100000;
                }
            }
            return res;
        }
    }

}
