package com.bantanger.leetcode.double_pointer;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 23:03
 */
public class LC_344_reverse {
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
}
