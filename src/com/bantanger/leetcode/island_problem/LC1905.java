package com.bantanger.leetcode.island_problem;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 20:22
 */
public class LC1905 {
    class Solution {
        int m, n;

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            // 当岛屿b所有陆地在岛屿a里也是陆地是才算子岛屿
            // 如果岛屿b的某一陆地在岛屿a里是海水，那岛屿b不算a岛屿的子岛屿
            // 遍历岛屿b，把不可能是子岛屿的岛屿排除掉，剩下的就是结果
            m = grid1.length;
            n = grid1[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                        // 当岛屿1为海水，岛屿2却是岛屿，绝对不可能是子岛屿，删除
                        dfs(grid2, i, j); // 调用dfs淹没这个岛屿
                    }
                }
            }
            int res = 0;
            // 查看现在grid2还剩下的岛屿
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        res++;
                        dfs(grid2, i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= m || j >= n) return;
            if (grid[i][j] == 0) return;
            grid[i][j] = 0;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
