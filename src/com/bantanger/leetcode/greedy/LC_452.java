package com.bantanger.leetcode.greedy;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/30 10:10
 */
public class LC_452 {
    class Solution {
        // 区间调度问题
        public int findMinArrowShots(int[][] intvs) {
            if (intvs.length == 0) return 0;
            // 按 end 升序排序,注意这里不能用o1[1] - o2[1]，intvs集合长度在-2^31 <= xstart < xend <= 2^31 - 1
            Arrays.sort(intvs, (o1, o2) -> Integer.compare(o1[1], o2[1]));
            // 直接相减如果遇到[[-2147483646,-2147483645],[2147483646,2147483647]]这样的的数据会导致int溢出

            // 至少有一个区间不相交
            int count = 1;
            // 排序后，第一个区间就是 x
            int x_end = intvs[0][1];
            for (int[] interval : intvs) {
                int start = interval[0];
                // 把 >= 改成 > 就行了
                if (start > x_end) {
                    count++;
                    x_end = interval[1];
                }
            }
            return count;
        }
    }

}
