package com.bantanger.leetcode.Question_of_the_day.may_oneweek.data_2022_05_01;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/1 20:36
 */
public class LC_1305_twoTreeMerge {
    class Solution_CollectionsQSort {
        List<Integer> res = new ArrayList<>();

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            addNum(root1);
            addNum(root2);
            Collections.sort(res);
            return res;
        }

        private void addNum(TreeNode root) {
            if (root == null) return;
            res.add(root.val);
            addNum(root.left);
            addNum(root.right);
        }
    }

    class Solution_Merge {
        int INF = 0x3f3f3f3f;
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> res = new ArrayList<>();
            List<Integer> res1 = new ArrayList<>();
            List<Integer> res2 = new ArrayList<>();

            addNum(root1, res1);
            addNum(root2, res2);
            int n = res1.size(), m = res2.size();
            int i = 0, j = 0;
            while(i < n || j < m){
                int a = i < n ? res1.get(i) : INF;
                int b = j < m ? res2.get(j) : INF;
                if(a <= b){
                    res.add(a);
                    i++;
                } else {
                    res.add(b);
                    j++;
                }
            }
            return res;
        }

        private void addNum(TreeNode root, List<Integer> helperRes) {
            if (root == null) return;
            addNum(root.left, helperRes);
            helperRes.add(root.val);
            addNum(root.right, helperRes);
        }
    }

    /*
    BST有序迭代器法
     */
    class Solution_BSTIterator {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            BSTIterator t1 = new BSTIterator(root1);
            BSTIterator t2 = new BSTIterator(root2);
            LinkedList<Integer> res = new LinkedList<>();
            // 类似合并有序链表的操作
            while(t1.hasNext() && t2.hasNext()){
                if(t1.peek() > t2.peek()){
                    res.add(t2.next());
                } else {
                    res.add(t1.next());
                }
            }
            // 如果有一颗BST还剩下元素，直接添加到res后面，
            // BSTIterator得到的都是有序的
            // 两个while只会执行一个
            while(t1.hasNext()){
                res.add(t1.next());
            }
            while(t2.hasNext()){
                res.add(t2.next());
            }
            return res;
        }
    }

    class BSTIterator{
        Stack<TreeNode> st = new Stack<>();
        private void pushBranch(TreeNode p){
            while( p != null){
                st.push(p);
                p = p.left;
            }
        }
        public BSTIterator(TreeNode root){
            pushBranch(root);
        }
        public boolean hasNext(){
            return !st.isEmpty();
        }
        public int next(){
            TreeNode p = st.pop();
            pushBranch(p.right);
            return p.val;
        }
        public int peek(){
            return st.peek().val;
        }
    }
}
