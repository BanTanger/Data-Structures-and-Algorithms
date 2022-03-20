package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/19 22:16
 */
public class LC_131 {
    class Solution {
        List<List<String>> lists = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();

        public List<List<String>> partition(String s) {
            backtracking(s, 0);
            return lists;
        }

        public void backtracking(String s, int startIndex) {
            if (startIndex >= s.length()) { // 递归的for已经遍历到最后一个孩子
                lists.add(new ArrayList(deque)); // 不是回文的数据在单层逻辑中已经被筛去
                return;
            }

            for (int i = startIndex; i < s.length(); i++) {
                // 记录回文字符串
                if (isPalindrome(s, startIndex, i)) {
                    String str = s.substring(startIndex, i + 1);
                    deque.addLast(str);
                } else continue;
                // 递归
                backtracking(s, i + 1);
                // 一开始要截取位置1的元素 和 切割过的元素不能要，直接跳过
                deque.removeLast(); // 回溯
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            // 双指针
            for (int i = start, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
