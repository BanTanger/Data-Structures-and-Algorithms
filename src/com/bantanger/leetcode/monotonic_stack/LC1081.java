package com.bantanger.leetcode.monotonic_stack;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 11:43
 */
public class LC1081 {
    class Solution {
        public String smallestSubsequence(String s) {
            /*与LC316一模一样，直接CV了*/
            int[] count = new int[256];
            boolean[] inStack = new boolean[256]; // ASCII值
            Stack<Character> st = new Stack<>();
            char[] cs = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }
            for (char c : cs) {
                count[c]--;
                if (inStack[c]) continue;
                while (!st.isEmpty() && st.peek() > c) {
                    if (count[st.peek()] == 0) break;
                    inStack[st.pop()] = false;
                }
                st.push(c);
                inStack[c] = true;
            }
            StringBuffer sb = new StringBuffer();
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            // 栈里的元素是逆向弹出的，所以返回时需要逆回来
            return sb.reverse().toString();
        }
    }
}
