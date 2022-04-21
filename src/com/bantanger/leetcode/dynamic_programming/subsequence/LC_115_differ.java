package com.bantanger.leetcode.dynamic_programming.subsequence;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/21 14:25
 */
public class LC_115_differ {
    class Solution {
        public int numDistinct(String s, String t) {
            int n = s.length(), m = t.length();
            int[][] dp = new int[n + 1][m + 1];

            // dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
            // 那么dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
            for (int i = 0; i <= n; i++) dp[i][0] = 1;
            // 再来看dp[0][j]，dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
            // 那么dp[0][j]一定都是0，s如论如何也变成不了t。
            for (int j = 0; j <= m; j++) dp[0][j] = 0;

            // 注意这里位置不能放在上面，因为会被j的初始化覆盖
            // dp[0][0]应该是1，空字符串s，可以删除0个元素，变成空字符串t。
            dp[0][0] = 1;

            /*System.out.println("=========test========");
            for(int[] x : dp){
                for(int y : x){
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            System.out.println("=========test========");*/

            for (int i = 1; i <= n; i++) {
                /*System.out.print("   "+ t.charAt(0) + " " + t.charAt(1) + " " + t.charAt(2));
                System.out.println();
                System.out.print(s.charAt(i - 1) + ": ");*/

                for (int j = 1; j <= m; j++) {
                    System.out.println();
                    System.out.println("执行到第 " + j + " 层");
                    System.out.println("s:" + s + " t:" + t);
                    System.out.println(s.substring(i - 1,i));
                    System.out.println(t.substring(j - 1,j));
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                        System.out.println("-----相同-----");
                        System.out.println("s.charAt(i - 1) == t.charAt(j - 1)");
                        System.out.println("  dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]");
                        System.out.printf("     dp[i][j] --> " + "dp[%d][%d] = %d\n", i, j, dp[i][j]);
                        System.out.printf("     dp[i - 1][j - 1] --> " + "dp[%d][%d] = %d\n", i - 1, j - 1, dp[i - 1][j - 1]);
                        System.out.printf("     dp[i - 1][j] --> " + "dp[%d][%d] = %d\n", i - 1, j, dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        System.out.println("-----不相同-----");
                        System.out.println("s.charAt(i - 1) != t.charAt(j - 1)");
                        System.out.println("  dp[i][j] = dp[i - 1][j]");
                        System.out.printf("     dp[i][j] --> " + "dp[%d][%d] = %d\n", i, j, dp[i][j]);
                        System.out.printf("     dp[i - 1][j] --> " + "dp[%d][%d] = %d\n", i - 1, j, dp[i - 1][j]);
                    }
                    // System.out.print(dp[i][j] + " ");
                }
                /*System.out.println();
                System.out.println("--------------");*/
            }
            return dp[n][m];
        }
    }
    @Test
    public void test(){
        String s = "baegg";
        String t = "bag";

        new Solution().numDistinct(s,t);
    }
}
