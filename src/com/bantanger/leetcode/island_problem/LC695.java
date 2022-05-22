package com.bantanger.leetcode.island_problem;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 13:25
 */
public class LC695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            // 这题就和LC1020处理岛屿的手法一样，只是不需要删除边界岛屿
            // 做一个最大值，每次计算岛屿之后就更新岛屿面积和最大值。
            // 通过给dfs设置返回值的方式在淹没岛屿前把岛屿的面积记录下来
            int n = grid.length, m = grid[0].length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            int n = grid.length, m = grid[0].length;
            if (i < 0 || j < 0 || i >= n || j >= m) return 0;
            if (grid[i][j] == 0) return 0;

            grid[i][j] = 0;
            return dfs(grid, i - 1, j)
                    + dfs(grid, i + 1, j)
                    + dfs(grid, i, j - 1)
                    + dfs(grid, i, j + 1) + 1;
            // 这里加一是对dfs每一个岛屿面积做记录。学到了
            /* 注意dfs返回值要+1，
            这是对dfs的每一个岛屿面积做记录，
            可以认为是数组操作里遍历到一个数就+1，
            只不过换成递归就是这样写 */
        }
    }
}
