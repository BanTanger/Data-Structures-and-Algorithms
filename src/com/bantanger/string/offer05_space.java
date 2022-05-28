package com.bantanger.string;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 18:39
 */
public class offer05_space {
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) return s;
            StringBuffer sb = new StringBuffer();
            int n = s.length();
            // 遇到空格扩大数组容量
            // 为什么步进两步，是因为一个空格要替换成三个字符
            // 加上原本有的空格，还要两个额外的空间存放剩余字符才行，所以步进两步。
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ' ') {
                    sb.append(" ").append(" ");
                }
            }
            if (sb.length() == 0) return s;
            int left = s.length() - 1; // 左指针指向旧字符串的末尾
            s += sb.toString(); // 给旧字符串扩容
            int right = s.length() - 1; // 右指针指向旧字符串的末尾
            // 不能直接对字符串进行修改，所以需要变成数组
            char[] ch = s.toCharArray();
            while (left >= 0 && right >= 0) {
                if (ch[left] != ' ') {
                    ch[right--] = ch[left--];
                } else {
                    ch[right--] = '0';
                    ch[right--] = '2';
                    ch[right--] = '%';
                    left--;
                }
            }
            return new String(ch);
        }
    }
}
