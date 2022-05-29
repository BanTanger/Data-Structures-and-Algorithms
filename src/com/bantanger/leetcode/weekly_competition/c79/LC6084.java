package com.bantanger.leetcode.weekly_competition.c79;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 23:09
 */
public class LC6084 {
    class Solution {
        public String largestWordCount(String[] messages, String[] senders) {
            // 首先遍历发送者, 映射下标关系
            HashMap<Integer, String> map = new HashMap<>();
            HashMap<String, Integer> sender = new HashMap<>();
            int n = senders.length;
            for (int i = 0; i < n; i++) {
                map.put(i, senders[i]);
            }
            for (int i = 0; i < n; i++) {
                String[] word = messages[i].split(" ");
                String s1 = map.get(i);
                for (String s : word) {
                    sender.put(s1, sender.getOrDefault(s1, 0) + 1);
                }
            }
            int max = 0;
            String ans = senders[0];
            for(int i = 0; i < n; i++) {
                String s = map.get(i);
                Integer count = sender.get(s);
                if(count > max) {
                    max = count;
                    ans = s;
                }
                if(count == max) {
                    max = count;
                    ans = (ans.compareTo(s) > 0) ? ans : s;
                }
            }
            return ans;
        }
    }
    @Test
    public void test() {
        /*String[] messages = {"p mmV","Lb WE u H x f YT","Rey","q","Y R","Ng","mP lo oA l jd y","CP y r N wHA","Bt l","Y S xv MNS","WG vz","S pl l Dz fX D TpI","zGq","z S D"};
        String[] senders = {"QMnVn","QMnVn","nkq","o","EEM","QMnVn","o","nkq","Gd","Gd","nkq","o","EEM","EEM"};*/

        /*String[] messages = {"How is leetcode for everyone","Leetcode is useful for practice"};
        String[] senders = {"Bob","Charlie"};*/

        String[] messages = {"tP x M VC h lmD","D X XF w V","sh m Pgl","pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np","j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N","Yi Bts","gp No g s VR","py A S sNf","ZS H Bi De dj dsh","ep MA KI Q Ou"};
        String[] senders = {"OXlq","IFGaW","XQPeWJRszU","Gb","HArIr","Gb","FnZd","FnZd","HArIr","OXlq","IFGaW","XQPeWJRszU","EMoUs","Gb","EMoUs","EMoUs"};

        /*String s1 = "Bob";
        String s2 = "Charlie";
        System.out.println(s2.compareTo(s1));*/
        System.out.println(new Solution().largestWordCount(messages, senders));
    }
}
