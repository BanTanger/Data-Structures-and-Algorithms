package com.bantanger.tree;

import javax.swing.tree.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class BuildTree {
    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode helper(int[] inorder, int inLeft, int inRight,
                           int[] postorder, int postLeft, int postRight) {
        if (inRight - inLeft < 1) return null; // 没有元素切割了
        if (inRight - inLeft == 1) return new TreeNode(inorder[inLeft]); // 切割到只有一个元素时建树

        // 后序数组postorder里最后一个即为根节点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根节点的值找到该值在中序数组inorder的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // 切割中序数组
        // 左中序区间，左闭右开[)
        int leftInorderBegin = inLeft;
        int leftInorderEnd = rootIndex;
        // 右中序区间，左闭右开[)
        int rightInorderBegin = rootIndex + 1;
        int rightInorderEnd = inRight;

        // 切割后序数组
        // 左后序区间，左闭右开[leftPostorderBegin,leftPostorderEnd)
        int leftPostorderBegin = postLeft;
        int leftPostorderEnd = postLeft + (rootIndex - inLeft);
        // 右后序区间，左闭右开[rightPostorderBegin,rightPostorderEnd)
        int rightPostorderBegin = postLeft + (rootIndex - inLeft);
        int rightPostorderEnd = postRight - 1; // 排除最后一个元素，已经作为了节点

        // Print Login
        System.out.println("------------");
        System.out.println("leftInorder:");
        for (int i = leftInorderBegin; i < leftInorderEnd; i++) {
            System.out.println(inorder[i] + " ");
        }
        System.out.println();

        System.out.println("------------");
        System.out.println("rightInorder:");
        for (int i = rightInorderBegin; i < rightPostorderEnd; i++) {
            System.out.println(inorder[i] + " ");
        }
        System.out.println();

        System.out.println("------------");
        System.out.println("leftPostorder:");
        for (int i = leftPostorderBegin; i < leftPostorderEnd; i++) {
            System.out.println(inorder[i] + " ");
        }
        System.out.println();

        System.out.println("------------");
        System.out.println("rightPostorder:");
        for (int i = rightPostorderBegin; i < rightPostorderEnd; i++) {
            System.out.println(inorder[i] + " ");
        }
        System.out.println();

        // 根据rootIndex划分左右子树
        root.left = helper(inorder, leftInorderBegin, leftInorderEnd,
                postorder, leftPostorderBegin, leftPostorderEnd);
        root.right = helper(inorder, rightInorderBegin, rightInorderEnd,
                postorder, rightPostorderBegin, rightPostorderEnd);

        return root;
    }
}

