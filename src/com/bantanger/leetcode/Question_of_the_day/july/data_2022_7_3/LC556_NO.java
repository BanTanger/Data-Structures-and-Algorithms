package com.bantanger.leetcode.Question_of_the_day.july.data_2022_7_3;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/3 8:28
 */
public class LC556_NO {
    class Solution {
        /*这个是求最大整数*/
        public int nextGreaterElement(int n) {
            String str = n + "";
            char[] ch = str.toCharArray();
            Integer[] arr = new Integer[ch.length];
            for (int i = 0; i < ch.length; i++) {
                arr[i] = ch[i] - '0';
            }
            Arrays.sort(arr, (o1, o2) -> o2 - o1);
            // System.out.println(Arrays.toString(arr));
            // double a = 2e31 - 1;
            // System.out.println(a);
            StringBuffer sb = new StringBuffer();
            for (int i : arr) {
                sb.append(i);
            }
            long ans = Long.parseLong(sb.toString());
            ans = ans == n ? -1 : ans;
            ans = ans > Integer.MAX_VALUE ? -1 : ans;
            return (int) ans;
        }
    }
}
