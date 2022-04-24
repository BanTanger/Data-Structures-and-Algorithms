package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/24 8:44
 */
public class LC_647_Palindromic {

    class Solution2 {
        public int countSubstrings(String s) {
            int len , ans = 0;
            if(s == null || (len = s.length()) < 1) return 0;
            for(int i = 0; i < len; i++){
                ans += palindromic(s,i,i);
                ans += palindromic(s,i,i + 1);
            }
            return ans;
        }

        private int palindromic(String s, int l, int r){
            // 这个代码逻辑是找每一个回文串
            int res = 0;
            while(l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)){
                l--; r++;
                res++;
            }
            return res;
        }
    }

    class Solution {
        public int countSubstrings(String s) {
            if(s.length() == 1) return 1;
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                String odd = Palindromic(s, i, i);
                String even = Palindromic(s, i, i+1);
                count = odd.equals("") ? count : count + 1;
                count = even.equals("") ? count : count + 1;
                System.out.println(odd);
                System.out.println(even);
            }
            return count;
        }

        private String Palindromic(String s, int i, int j){
            // 这个代码逻辑是选最长回文串
            while(i >= 0 && j < s.length()
                    && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            return s.substring(i+1, j);
        }
    }



    @Test
    public void test(){
        new Solution().countSubstrings("aaa");
    }
}
