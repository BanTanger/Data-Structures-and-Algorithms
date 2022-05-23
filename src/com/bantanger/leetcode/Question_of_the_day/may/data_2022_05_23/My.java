package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_23;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 19:59
 */
public class My {
    class Solution {
        int m, n;
        int[][] temp;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int cutOffTree(List<List<Integer>> forest) {
            m = forest.size();
            n = forest.get(0).size();
            temp = new int[m][n];
            List<int[]> res = new ArrayList<>(); // 记录当前树的三维坐标
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    temp[i][j] = forest.get(i).get(j);
                    if(temp[i][j] > 1) {
                        res.add(new int[]{temp[i][j], i, j});
                    }
                }
            }
            // 按照树的高度进行排序
            Collections.sort(res, (o1, o2) -> o1[0] - o2[0]);
            if(temp[0][0] == 0) return -1; // 此数组没有被排序，树没有被破坏
            int xPre = 0, yPre = 0;
            int ans = 0;
            // 依次取出当前高度最低的树
            for(int[] cur : res) {
                System.out.println(Arrays.toString(cur));
                int distance = bfs(xPre, yPre, cur[1], cur[2]);
                if(distance == -1) return -1;
                ans += distance;
               /* System.out.println("distance => "  + distance);
                System.out.println("ans => "  + ans);*/
                // 更新树的坐标
                xPre = cur[1];
                yPre = cur[2];
            }
            return ans;
        }

        private boolean isForest(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }

        // i1, j1代表开始坐标， i2，j2代表结束坐标
        // 不知道终点，不能使用双向BFS
        private int bfs(int i1, int j1, int i2, int j2) {
            if(i1 == i2 && j1 == j2) return 0;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            q.offer(new int[]{i1, j1});

            visited[i1][j1] = true;
            int step = 0;
            while(!q.isEmpty()) {
                int sz = q.size();
                step++;
                for(int i = 0; i < sz; i++) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1]; // 拿当前节点的下标
                    for(int[] dir : dirs) {
                        int next_i = dir[0] + x;
                        int next_j = dir[1] + y;
                        if(next_i == i2 && next_j == j2) return step;

                        // 确保当前放入的是树或者是空地
                        if(isForest(next_i, next_j) && !visited[next_i][next_j] && temp[next_i][next_j] > 0) {
                            q.offer(new int[]{next_i, next_j});
                            visited[next_i][next_j] = true;
                        }
                    }
                    System.out.println();
                }
            }
            return -1;
        }
    }
    @Test
    public void test(){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new LinkedList<Integer>(Arrays.asList(2,3,4)));
        res.add(new LinkedList<Integer>(Arrays.asList(0,0,5)));
        res.add(new LinkedList<Integer>(Arrays.asList(8,7,6)));
        new Solution().cutOffTree(res);
    }
}
