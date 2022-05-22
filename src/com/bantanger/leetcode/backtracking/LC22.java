package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 20:21
 */
public class LC22 {
    class Solution {
        // 使用res列表记录所有合法括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuffer path = new StringBuffer();

        public List<String> generateParenthesis(int n) {
            // 使用回溯进行暴力生成
            if (n == 0) return res;
            backtracking(n, n);
            return res;
        }

        /* left:可使用的左括号数量  right:可使用的右括号数量 */
        private void backtracking(int left, int right) {
            /* 剪枝操作 */
            // 左括号剩下的多，说明不合法
            if (right < left) return;
            // 如果左右括号任意一个数量小于0，说明不合法
            if (left < 0 || right < 0) return;
            // 如果左右括号都等于0，代表生成合法，记录在res里
            if (left == 0 && right == 0) {
                res.add(path.toString());
                return;
            }

            // 尝试放一个左括号
            path.append('('); // 选择
            backtracking(left - 1, right);
            path.deleteCharAt(path.length() - 1); // 撤销，回溯

            // 尝试放一个右括号
            path.append(')'); // 选择
            backtracking(left, right - 1);
            path.deleteCharAt(path.length() - 1); // 撤销，回溯
        }
    }
}
