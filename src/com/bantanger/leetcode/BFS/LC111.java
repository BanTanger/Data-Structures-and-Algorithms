package com.bantanger.leetcode.BFS;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 20:59
 */
public class LC111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // root本身也是一层，所以把depth初始化为1
            int depth = 1;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    // 判断是否到达终点
                    if (cur.left == null && cur.right == null) return depth;
                    // 将cur相邻节点全部加进队列里
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
                // 增加步数
                depth++;
            }
            return depth;
        }
    }
}
