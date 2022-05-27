package com.bantanger.leetcode.weekly_competition.c77;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/27 16:57
 */
public class LC2257 {
    class Solution {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int ans = 0;
            //用于存储当前格子的状态(围墙W/守卫G/守卫守护的范围I)
            char[][] grid = new char[m][n];
            //将守卫放到所在的位置上
            for (int[] guard : guards) {
                grid[guard[0]][guard[1]] = 'G';
            }
            //将墙立到所在的位置上
            for (int[] wall : walls) {
                grid[wall[0]][wall[1]] = 'W';
            }
        /*
        对于每一个守卫，会有三种情况
        1；前方什么都没有，我们可以一直看下去
        2；前方有一堵墙，会阻碍我们的视线
        3；前方又有一个守卫，这时候我们视线方向已经被前方的守卫所看到
         */
            for (int[] guard : guards) {
                int x = guard[0], y = guard[1];

                for (int i = 0; i < 4; i++) {
                    //用方向数组实现
                    int nx = x +  direction[i][0], ny = y + direction[i][1];
                    //判断是否越界
                    while (nx >= 0 && nx < m && ny >= 0 && ny < n
                            && grid[nx][ny] != 'G' && grid[nx][ny] != 'W') {
                        //前方不是守卫也不是墙，我们继续沿着这个方向看过去，并且将视野所及标为I
                        grid[nx][ny] = 'I';
                        //继续朝着该方向向前看
                        nx += direction[i][0];
                        ny += direction[i][1];
                    }
                }
            }

//        for (char[] gd : grid) {
//            System.out.println(Arrays.toString(gd));
//        }
            //不是墙，守卫，视野所及区域都为答案
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 'G' && grid[i][j] != 'W' && grid[i][j] != 'I') ans++;
                }
            }
            return ans;
        }
    }
}
