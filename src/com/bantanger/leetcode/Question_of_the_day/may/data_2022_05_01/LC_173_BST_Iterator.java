package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_01;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/1 21:17
 */
public class LC_173_BST_Iterator {
    class BSTIterator {
        // 模拟递归栈
        private Stack<TreeNode> st = new Stack<>();

        // 左侧树枝一直放入栈中。
        private void pushBranch(TreeNode p) {
            while (p != null) {
                st.push(p);
                p = p.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushBranch(root);
        }

        public int next() {
            TreeNode p = st.pop();
            pushBranch(p.right);
            return p.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }
    }
}
