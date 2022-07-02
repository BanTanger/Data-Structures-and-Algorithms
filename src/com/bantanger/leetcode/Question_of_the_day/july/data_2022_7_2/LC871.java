package com.bantanger.leetcode.Question_of_the_day.july.data_2022_7_2;

import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/2 23:15
 */
public class LC871 {
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            //这一题就是优先队列的应用，太扯淡了
            //完全就是特题特解，别的方法都相形见绌
            //优先队列可以是nlogn的解法，这太霸道了
            if (stations.length == 0)
                return startFuel >= target ? 0 : -1;
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
                return o2 - o1;
            });
            int sum = startFuel;
            int ans = 0;
            for (int i = 0; i < stations.length; i++) {
                while (sum < stations[i][0]) {
                    Integer ii = queue.poll();
                    if (ii == null) return -1;
                    sum += ii;
                    ans++;
                }
                queue.offer(stations[i][1]);
            }
            while (sum < target) {
                Integer ii = queue.poll();
                if (ii == null) return -1;
                sum += ii;
                ans++;
            }
            return ans;
        }
    }
}
