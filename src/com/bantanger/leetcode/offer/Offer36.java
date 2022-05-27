package com.bantanger.leetcode.offer;

import com.bantanger.linkedlist.Node;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/27 13:09
 */
public class Offer36 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
        private void dfs(Node cur) {
            if(cur == null) return ;
            dfs(cur.left);
            if(pre != null) pre.right = cur;
            else if(pre == null) head = cur; // head保存头节点
            cur.left = pre; // 左指针指向当前父节点
            pre = cur;
            dfs(cur.right);
        }
    }
}
