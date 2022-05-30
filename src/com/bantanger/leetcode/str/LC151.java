package com.bantanger.leetcode.str;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/30 18:18
 */
public class LC151 {
    class Solution {
        public String reverseWords(String s) {
            // 删除多余空格
            StringBuilder sb = removeSpace(s);
            // 反转整个字符串
            reverseString(sb, 0, sb.length() - 1);
            // 反转每一个单词
            reverseEachWord(sb);
            return sb.toString();
        }

        private StringBuilder removeSpace(String s) {
            // 删除多余空格
            int n = s.length();
            int start = 0, end = n - 1;
            while (s.charAt(start) == ' ') start++; // 删除前导空格
            while (s.charAt(end) == ' ') end--; // 删除后导空格
            StringBuilder sb = new StringBuilder();
            while (start <= end) {
                // 删除中间多余空格
                char c = s.charAt(start);
            /* 只有c不为空格的时候才能加入sb
                不然就不加入，start进一，默认添加空格
               限制只能有一个空格通过 */
                if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }
                start++; // start前进， 默认没读的元素是空格
            }
            return sb;
        }

        private void reverseString(StringBuilder sb, int start, int end) {
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
        }

        private void reverseEachWord(StringBuilder sb) {
            int l = 0, r = 1;
            int n = sb.length();
            while (l < n) {
                while (r < n && sb.charAt(r) != ' ') r++;
                reverseString(sb, l, r - 1); // 寻找一个单词区间进行反转
                l = r + 1; // 左指针跳到右指针后面
                r = l + 1; // 右指针跳到(当前)左指针后面
            }
        }
    }
    @Test
    public void test() {
        String s = "  hello world  ";
        new Solution().reverseWords(s);
    }
}
