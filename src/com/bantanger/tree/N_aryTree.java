package com.bantanger.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class N_aryTree {
    public List<Integer> preorder(Node root){
        List<Integer> res = new ArrayList<>();
        preorderRecur(root,res);
        return res;
    }
    public void preorderRecur(Node root,List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.value);
        for(Node child : root.children){
            preorderRecur(child,res);
        }
    }
}
