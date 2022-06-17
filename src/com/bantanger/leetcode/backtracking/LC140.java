package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/17 16:14
 */
public class LC140 {
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            dfs(s, wordDict, new ArrayList<>(), 0);
            return res;
        }

        private void dfs(String s, List<String> wordDict,
                         List<String> path, int startIndex) {
            if (startIndex == s.length()) {
                res.add(new String(String.join(" ", path))); /*java8特有方法，第一个参数是连接符
                有点类似于set，where标签那样，不补充首和尾*/
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (wordDict.contains(s.substring(startIndex, i))) {
                    path.add(s.substring(startIndex, i));
                    dfs(s, wordDict, path, i); // 可重，i不需要自加
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
