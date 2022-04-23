package com.bantanger.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 10:24
 */
public class LC_76_minWindow {
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need, window;
            need = new HashMap<>();
            window = new HashMap<>();
            for (char c : t.toCharArray())
                need.put(c, need.getOrDefault(c, 0) + 1);
            int left = 0, right = 0;
            int valid = 0; // 表示窗口满足need条件的字符个数
            // 如果valid和need.size()的大小相等，代表窗口已满足条件，完全覆盖字符串T
            // 记录最小覆盖子串开始位置和其长度
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                // 开始滑动
                // c 是将要移入窗口的字符,放入后扩大窗口（右扩）
                char c = s.charAt(right++);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)))
                        valid++;
                }

                // 判断左侧窗口是否要进行收缩
                while (valid == need.size()) {
                    // 更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    // d 是即将移出窗口的字符，移除后缩小窗口（左缩）
                    char d = s.charAt(left++);
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d)))
                            valid--;
                        window.put(c, window.getOrDefault(c, 0) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
        }
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        new Solution().minWindow(s,t);
    }
}
