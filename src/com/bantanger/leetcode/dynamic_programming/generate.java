package com.bantanger.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/21 20:10
 */
public class generate {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 递推公式为：S[i][j] = S[i - 1][j - 1] + S[i - 1][j]
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        ans.add(1);
                    } else {
                        //第i层的第j个元素 = i-1层的第j个元素 + i-1层的第j-1元素
                        ans.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                    }
                }
                res.add(ans);
            }
            return res;
        }
    }
}
