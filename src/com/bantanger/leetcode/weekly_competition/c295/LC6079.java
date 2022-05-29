package com.bantanger.leetcode.weekly_competition.c295;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/29 11:05
 */
public class LC6079 {
    class Solution {
        public String discountPrices(String sentence, int discount) {
            // 先进行切割，然后定位$的位置，
            // 如果下一个数是数字就是一个价格，下一个数不是数字或者越界就代表不是价格
            String[] words = sentence.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String price : words) {
                int idx = price.indexOf("$");
                if (idx == 0 && idx + 1 < price.length() &&
                        (price.charAt(idx + 1) <= '9' && price.charAt(idx + 1) > '0')
                && isPrice(price.substring(idx + 1))) {
                    double q = (double)discount / 100 == 1 ? 0 : 1 - (double)discount / 100;
                    double num = (double)(Long.parseLong(price.substring(idx + 1))) * q;
                    String newPrice = "$" + String.format("%.2f", num);
                    sb.append(newPrice).append(" ");
                } else {
                    sb.append(price).append(" ");
                }
            }
            return sb.toString().trim();
        }
        private boolean isPrice(String price) {
            for(int i = 0; i < price.length(); i++) {
                if(price.charAt(i) > '9' || price.charAt(i) < '0') return false;
            }
            return true;
        }
    }
    @Test
    public void test() {
        String test = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        int count = 28;
        System.out.println(new Solution().discountPrices(test, count));
    }
}
