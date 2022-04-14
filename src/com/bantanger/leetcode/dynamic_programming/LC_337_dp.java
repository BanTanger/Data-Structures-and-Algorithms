package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/14 9:00
 */
public class LC_337_dp {
    /**
     * 3.状态标记递归
     * 执行用时：0 ms , 在所有 Java 提交中击败了 100% 的用户
     * 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
     * Math.max(rob(root.right)[0], rob(root.right)[1])
     * 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     *
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        // 定义树形dp，0代表不偷，1代表偷
        int[] res = new int[2];
        // 终止条件
        if(root == null) return res;
        // 定义左右数组，拿取当前节点左右递归后偷与不偷的所有结果
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]); // 不偷：选出左右子树偷与不偷的最好情况
        res[1] = root.val + left[0] + right[0]; // 偷：当前节点数据加上左子树不偷情况和右子树不偷情况
        return res;
    }
}
