package com.bantanger.leetcode.Question_of_the_day.may_oneweek.data_2022_05_02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/2 19:57
 */
public class LC_591_XML {
    class Solution {
        public boolean isValid(String s) {
            String preCDATA = "<![CDATA[", beCDATA = "]]>";
            int n = s.length(), i = 0;
            Deque<String> d = new ArrayDeque<>();
            while (i < n) {
                // 先比较是否为CDATA
                if (i + 8 < n // 防越界
                        && s.substring(i, i + 9).equals(preCDATA)) {
                    if (i == 0) return false; // CDATA不能置于开头
                    int j = i + 9;
                    boolean ok = false; // 设置一个布尔变量用来标记当前标签没有闭合
                    while (j < n && !ok) {
                        if (j + 2 < n && s.substring(j, j + 3).equals(beCDATA)) {
                            ok = true; // 标签闭合成功
                            j += 3; // j 指针跳跃到右标签下一个位置
                        } else {
                            j++; // j指针移动直到末尾。
                        }
                    }
                    if (!ok) return false;
                    i = j; // 整个循环依靠i指针移动，所以内层的j要把值赋给i
                } else if (s.charAt(i) == '<') {
                    if (i == n - 1) return false;
                    boolean isEnd = s.charAt(i + 1) == '/';
                    int p = isEnd ? i + 2 : i + 1, j = p;
                    while (j < n && s.charAt(j) != '>') {
                        if (!Character.isUpperCase(s.charAt(j)))
                            return false; // 标签名不是大写就false
                        j++;
                    }
                    if (j == n) return false; // 如果j达到末尾，说明 > 没有出现
                    int len = j - p;
                    if (!(len <= 9 && len >= 1)) return false;
                    String tag = s.substring(p, j);
                    i = j + 1;
                    if (!isEnd) {
                        d.addLast(tag);
                    } else {
                        if (d.isEmpty() || !d.pollLast().equals(tag)) return false;
                        if (d.isEmpty() && i < n) return false;
                    }
                } else {
                    if (i == 0) return false; // 特殊位置判断，第一位必须是 <
                    i++; // 普通字符处理，指针移动。
                }
            }
            return d.isEmpty(); // 如果此时栈为空代表标签闭合，即匹配成功
        }
    }
}
