package com.bantanger.leetcode.tree.bst;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/15 9:23
 */
public class LC450_delete {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(null==root){
                return null;
            }
            if(key < root.val){
                root.left = deleteNode(root.left, key);
            }else if(key > root.val){
                root.right = deleteNode(root.right, key);
            }else{
                if(null==root.left){
                    return root.right;
                }
                if(null==root.right){
                    return root.left;
                }
                TreeNode cur = root.left;
                while(null != cur.right){
                    cur = cur.right;
                }
                cur.right = root.right;
                return root.left;
            }
            return root;
        }
    }
}
