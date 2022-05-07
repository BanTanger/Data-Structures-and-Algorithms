package com.bantanger.leetcode.Nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/7 21:46
 */
public class LC18_FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return N_SumTarget(nums, 4, 0, target);
        }

        List<List<Integer>> N_SumTarget(int[] nums, int n, int start, int target){
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if(n < 2 || n > len) return res;
            if(n == 2) {
                int left = start, right = len - 1;
                int sum = 0;
                while(left < right){
                    int small = nums[left], big = nums[right];
                    sum = small + big;
                    if(sum > target)
                        while(left < right && big == nums[right]) right--;
                    else if(sum < target)
                        while(left < right && small == nums[left]) left++;
                    else{
                        res.add(new ArrayList<Integer>(Arrays.asList(small, big)));
                        while(left < right && big == nums[right]) right--;
                        while(left < right && small == nums[left]) left++;
                    }
                }
            } else {
                int i = start;
                while(i < len){
                    int num = nums[i];
                    List<List<Integer>> sub = N_SumTarget(nums, n - 1, i + 1, target - num);
                    for(List<Integer> s : sub){
                        s.add(num);
                        res.add(s);
                    }
                    while(i < len && num == nums[i]) i++; // 跳过重复数字
                }
            }
            return res;
        }
    }}
