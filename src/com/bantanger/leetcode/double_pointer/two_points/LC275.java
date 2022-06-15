package com.bantanger.leetcode.double_pointer.two_points;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 12:44
 */
public class LC275 {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int l = 0, r = n;
            int res = 0;
            while(l < r) {
                int mid = l + r >> 1; // 猜测mid就是h指数
                int temp = n - mid; // 有多少篇能被引用。h指数
                if(temp <= citations[mid]) {
                    res = temp;
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] nums = {0,1,3,5,6};
        System.out.println(new Solution().hIndex(nums));
    }
}
