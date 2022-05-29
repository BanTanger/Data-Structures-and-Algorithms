package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_29;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/29 12:50
 */
public class LC468 {
    class Solution {
        public String validIPAddress(String IP) {
            if (IP == null) {
                return "Neither";
            }

            String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
            String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
            String regex1 = "([\\da-fA-F]{1,4})";
            String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

            String result = "Neither";
            if (IP.matches(regexIPv4)) {
                result = "IPv4";
            } else if (IP.matches(regexIPv6)) {
                result = "IPv6";
            }
            return result;
        }
    }
}
