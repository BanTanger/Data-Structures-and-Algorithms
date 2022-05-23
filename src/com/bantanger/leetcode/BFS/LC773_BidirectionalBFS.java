package com.bantanger.leetcode.BFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 17:56
 */
public class LC773_BidirectionalBFS {
    class Solution {
        public int slidingPuzzle(int[][] board) {
            int m = 2, n = 3;
            // 创建StringBuffer将初始数组转换成字符串，作为双向BFS的起点
            StringBuffer sb = new StringBuffer();
            String target = "123450"; // 双向BFS构建终点
            // 将2 * 3 大小的数组转换成字符串作为BFS起点
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
            }
            String start = sb.toString();

            // 压缩二维数组，记录一维字符串的相邻索引
            int[][] neighbor = new int[][]{
                    {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}
            };


            // BFS框架, 这里使用双向BFS
            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            Set<String> visited = new HashSet<>();
            // 从起点和终点开始双向BFS
            q1.add(start);
            q2.add(target);
            visited.add(start);

            int step = 0;
            while (!q1.isEmpty() && !q2.isEmpty()) {
                // 哈希集合遍历时不能更改，所以这里使用临时temp存储扩散结果
                Set<String> temp = new HashSet<>();
                // q1所有节点向周围扩散
                for (String cur : q1) {
                    // 查看当前节点是否达到终点
                    if (q2.contains(cur)) return step;
                    visited.add(cur); // 记录遍历过的节点

                    // 找到数字0的下标，因为只有0才能移动
                    int index = 0;
                    while (cur.charAt(index) != '0') {
                        index++;
                    }
                    // 将一个节点的未遍历节点放入集合中
                    // 将数字0和相邻的数字交换位置
                    for (int choose : neighbor[index]) {
                        String newBoard = swap(cur.toCharArray(), choose, index);
                        // 防止走回头路
                        if (!visited.contains(newBoard)) {
                            temp.add(newBoard);
                        }
                    }
                }
                step++;
                q1 = q2;
                q2 = temp;
            }
            return -1;
        }

        private String swap(char[] ch, int i, int j) {
            ch[i] ^= ch[j];
            ch[j] ^= ch[i];
            ch[i] ^= ch[j];
            return new String(ch);
        }
    }
}
