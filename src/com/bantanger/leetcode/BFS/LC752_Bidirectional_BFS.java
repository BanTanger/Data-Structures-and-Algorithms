package com.bantanger.leetcode.BFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 17:20
 */
public class LC752_Bidirectional_BFS {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> dead = new HashSet<>();
            for(String s : deadends) dead.add(s);
            // 使用集合而不是使用队列，可以快速判断元素是否存在
            // 双向BFS从起点和终点两端扩散，寻找交集
            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            Set<String> visited = new HashSet<>();

            int step = 0;
            q1.add("0000");
            q2.add(target);

            while(!q1.isEmpty() && !q2.isEmpty()) {
                // 哈希集合在遍历过程不能更改，所以使用临时temp存储扩散结果
                Set<String> temp = new HashSet<>();

                // 将q1中所有的节点向周围扩散
                for(String cur : q1) {
                    // 判断是否到达终点
                    if(dead.contains(cur)) continue;
                    if(q2.contains(cur)) return step;

                    // 记录当前遍历过的节点
                    visited.add(cur);

                    // 将一个节点的未遍历节点加入集合中
                    for(int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        // 防止成环
                        if(!visited.contains(up)) temp.add(up);
                        String down = minusOne(cur, j);
                        if(!visited.contains(down)) temp.add(down);
                    }
                }
                // 这里增加步数
                step++;
                // temp相当于q1
                // 交换q1，q2，下轮while就扩散q2
                q1 = q2;
                q2 = temp;
            }
            return -1;
        }

        private String plusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if(ch[j] == '9') ch[j] = '0';
            else ch[j] += 1;
            return new String(ch);
        }

        private String minusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if(ch[j] == '0') ch[j] = '9';
            else ch[j] -= 1;
            return new String(ch);
        }
    }
}
