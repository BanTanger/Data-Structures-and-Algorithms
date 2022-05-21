package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_21;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 13:00
 */
public class LC961 {
    class Solution {
        public int repeatedNTimes(int[] nums) {
            int[] res = new int[10010];
            for(int i = 0; i < nums.length; i++){
                if(res[nums[i]]++ > 1) return nums[i];
            }
            return 0;
        }
    }

    @Test
    public void test(){
        int[] temp = {1,2,3,3};
        new Solution().repeatedNTimes(temp);
    }
}
