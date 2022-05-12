package com.bantanger.leetcode.Question_of_the_day.may_oneweek.data_2022_05_11;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.ArrayList;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/12 10:49
 */
public class LC449_Dichotomize {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return null;
            ArrayList<Integer> res = new ArrayList<>();
            dfs1(root, res);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
                sb.append(",");
            }
            return sb.toString();
        }

        private void dfs1(TreeNode root, ArrayList<Integer> res) {
            if (root == null) return;
            res.add(root.val);
            dfs1(root.left, res);
            dfs1(root.right, res);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) return null;
            String[] s = data.split(",");
            return dfs2(s, 0, s.length - 1);
        }

        private TreeNode dfs2(String[] s, int start, int end) {
            if (start > end) return null;
            int l = start + 1, r = end, t = Integer.parseInt(s[start]);
            while (l < r) {
                int mid = l + r >> 1;
                if (Integer.parseInt(s[mid]) > t) r = mid;
                else l = mid + 1;
            }
            if (Integer.parseInt(s[r]) <= t) r++;
            TreeNode ans = new TreeNode(t);
            ans.left = dfs2(s, start + 1, r - 1);
            ans.right = dfs2(s, r, end);
            return ans;
        }
    }
}
