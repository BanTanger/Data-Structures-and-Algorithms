package com.bantanger.leetcode.Question_of_the_day.may_oneweek.data_2022_05_07;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_433 {
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            int count = 0;
            boolean[] status = new boolean[bank.length];
            // 创建一个备忘录，只要查找过的基因就不进行记录，防止走回头路
            Queue<String> queue = new LinkedList<>();
            int level = 0;
            queue.offer(start);
            while(!queue.isEmpty()){
                for(int size = queue.size(); size > 0; size--){
                    String cur = queue.poll();
                    if(cur.equals(end)) return level;
                    for(int i = 0; i < bank.length; i++){
                        if(status[i]) continue;
                        if(countDis(cur, bank[i]) == 1) {
                            // 把基因库里距离是一的字符串连成图进行bfs
                            status[i] = true;
                            queue.offer(bank[i]);
                        }
                    }
                }
                level++;
            }
            return -1;
        }
        private int countDis(String a, String b){
            int n = a.length(), m = 0;
            for(int i = 0; i < n; i++){
                if(a.charAt(i) != b.charAt(i)){
                    m++;
                }
            }
            return m;
        }
    }
}
