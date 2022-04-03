package com.bantanger.leetcode.Question_of_the_day;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/3 11:58
 */
public class LC_744_2022_04_03 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // 二分应用
            /*
            判断：有序 + 找数

            注意左闭右闭还是左闭右开，保证循环不变量

            因为字母是循环出现的，在二分之后还需要再检查一次，
            如果letters[right] > target 就返回 letters[right]

            否则返回头元素 letters[0]
             */
            int n = letters.length; // 长度
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right >> 1;
                if (letters[mid] > target) right = mid;
                else left = mid + 1;
            }
            return letters[right] > target ? letters[right] : letters[0];
        }
    }
}
