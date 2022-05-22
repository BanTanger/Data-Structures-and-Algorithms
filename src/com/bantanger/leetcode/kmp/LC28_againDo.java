package com.bantanger.leetcode.kmp;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 10:22
 */
public class LC28_againDo {
    class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(); // 匹配串长度
            int m = needle.length(); // 模式串长度
            int[] next = new int[m]; // 创建一个模式串的前缀表数组
            getNext(next, needle); // 构建前缀表数组
            int j = -1;
            for(int i = 0; i < n; i++) {
                // 如果当前i，j指针指向字符不匹配，就让j指针通过前缀表进行回退操作
                while(j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = next[j];
                }
                // 当前 i，j指针指向的字符相等，j指针向前移动一位，i指针通过for进位
                if(haystack.charAt(i) == needle.charAt(j + 1)) j++;
                // 如果j指针已经走到模式串末尾，代表匹配成功，
                // 返回在匹配串里第一次出现模式串字符下标的位置
                // 注意i定义是后缀末尾，所以当前它指向的是模式串末尾
                // 举例：hello， i位置在'l' ,下标为3， ll， j位置在'l',下标为1
                // 匹配串里第一次出现模式串字符下标的位置为 i - m + 1 : 3 - 2 + 1 = 2
                if(j == m - 1) return i - m + 1;
            }
            return -1; // 如果没有在for循环返回，代表没有成功匹配，返回-1
        }

        /* 这里j代表是前缀末尾， i代表的后缀末尾 */
        private void getNext(int[] next, String needle) {
            // 实现整体右移的next数组
            int j = -1;
            next[0] = j;
            for(int i = 1; i < needle.length(); i++) {
                // 前后缀不相等，j指针根据前缀表连续回退到相等位置或者回退到0位置
                while(j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                    j = next[j];
                }
                // 如果当前连续前缀和后缀指向字符相等，前后缀长度进一
                if(needle.charAt(i) == needle.charAt(j + 1)) j++;
                next[i] = j; // 将前缀长度赋给next[i]。（前缀表赋值操作）
            }
        }
    }
}
