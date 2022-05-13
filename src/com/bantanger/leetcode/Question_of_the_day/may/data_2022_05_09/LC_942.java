package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_09;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_942 {
    class Solution {
        public int[] diStringMatch(String s) {
            int[] perm = new int[s.length() + 1];
            int[] res = new int[perm.length];
            for(int i = 0; i < perm.length; i++){
                perm[i] = i;
            }
            char[] cs = s.toCharArray();
            int k = 0;
            for(int i = 0, j = cs.length; i < cs.length; i++){
                if(cs[i] == 'I'){
                    // 如果是 I 就顺序存储，不改变perm数组的顺序
                    res[i] = perm[k++];
                } else if(cs[i] == 'D') {
                    // 如果是 D 就逆序存储，将后面的元素插入前面，
                    // 这样子的话使用链表会好很多,但是题目要求返回的int[]，
                    // 链表转数组不太好记忆，多扩大一个空间。将数据存放在新数组中
                    res[i] = perm[j--];
                }
            }
            res[cs.length] = perm[k];
            return res;
        }
    }

    class Solution2 {
        public int[] diStringMatch(String s) {
            int n = s.length(), l = 0, r = n;
            int[] res = new int[n + 1];
            for(int i = 0; i < n; i++){
                res[i] = s.charAt(i) == 'I' ? l++ : r--;
            }
            res[res.length - 1] = l;
            return res;
        }
    }
    @Test
    public void test(){
        new Solution().diStringMatch("IDID");
    }
}
