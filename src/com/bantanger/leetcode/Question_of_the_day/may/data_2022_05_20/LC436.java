package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_20;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 13:00
 */
public class LC436 {
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            int[][] clone = new int[n][2];
            for(int i = 0; i < n; i++){
                clone[i] = new int[] {intervals[i][0], i};
            }
            Arrays.sort(clone, (a, b) -> a[0] - b[0] /* lambda表达式 对start值从小到大排序 */);
            int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                int l = 0, r = n - 1;
                while(l < r) {
                    int mid = l + r >> 1;
                    if(clone[mid][0] >= intervals[i][1]) r = mid;
                    else l = mid + 1;
                }
                res[i] = clone[r][0] >= intervals[i][1] ?
                        clone[r][1] /* 找到右侧区间 返回右侧区间的索引值 */
                        : -1 /* 没有找到右侧区间 返回 -1*/;
            }
            return res;
        }
    }

    @Test
    public void test(){
        int[][] temp = {{3,4},{2,3},{1,2}};
        new Solution().findRightInterval(temp);
    }
}
