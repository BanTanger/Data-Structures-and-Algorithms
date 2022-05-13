package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 16:25
 */
public class LC114 {
    class Solution {
        // 定义，将root为根节点的二叉树拉平成链表
        public void flatten(TreeNode root) {
            if(root == null) return ;
            // 左右树都拉平
            flatten(root.left);
            flatten(root.right);

            // 此时左右子树已经被拉平成了链表
            TreeNode left = root.left; // 拿到左子树拉平而成的链表头节点
            TreeNode right = root.right; // 拿到右子树拉平而成的链表头节点

            // 对根节点进行操作，将左链表插入根节点右子树位置
            root.left = null;
            root.right = left;

            // 原先的右子树拆开，先把左子树插入根节点的右子树中
            TreeNode p = root;
            while(p.right != null) {
                p = p.right; // 来到右链表（原左链表）末尾位置
            }
            p.right = right; // 右链表（原左链表）末尾位置将原先的右链表插入。
        }
    }
}
