package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_28;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 9:48
 */
public class LC1021 {
    class Solution {
        public String removeOuterParentheses(String s) {
            // 压栈(这里用队列应该会好一点)，统计左右括号数量
            Deque<Character> q = new LinkedList<>();
            int n = s.length();
            StringBuffer sb = new StringBuffer();
            int count = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    count++;
                    q.offer(c);
                } else if (c == ')') {
                    count--;
                    q.offer(c);
                }
                if (count == 0) {
                    q.pollFirst();
                    q.pollLast();
                    // 赶紧把队列全部弹出转存到sb里
                    int len = q.size();
                    for (int j = 0; j < len; j++) {
                        sb.append(q.poll());
                    }
                }
            }
            return sb.toString();
        }
    }

    @Test
    public void test() {
        String s = "(()())(())(()(()))";
        new Solution().removeOuterParentheses(s);
    }
}
