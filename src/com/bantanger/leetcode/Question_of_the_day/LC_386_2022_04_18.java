package com.bantanger.leetcode.Question_of_the_day;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/18 22:09
 */
public class LC_386_2022_04_18 {
    class Solution {
        List<Integer> res = new ArrayList<>();
        int n;

        public List<Integer> lexicalOrder(int n) {
            this.n = n; // 通过这样保存n,将局部变量的作用域提升为全局变量
            for (int i = 1; i <= 9; i++) {
                dfs(i);
            }
            return res;
        }

        private void dfs(int k) {
            if (k > n) return; // 如果递归的过程超过n直接返回
            res.add(k);
            if (k * 10 > n) return; // 剪枝操作
            // 例如进入1的下一层遍历 10 - 19 时，发现10已经大于 n 的情况直接结束

            // 如果一层遍历都添加完，进入下一层遍历
            // 1 - 9 结束， 从1开始进入10-19，一直往复这个过程
            for (int i = 0; i <= 9; i++) { // 从零开始是细节
                dfs(k * 10 + i);
            }
        }
    }
}
