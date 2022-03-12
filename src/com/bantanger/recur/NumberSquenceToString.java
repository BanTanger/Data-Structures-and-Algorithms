package com.bantanger.recur;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class NumberSquenceToString {
    // 题目要求:给定一个数字序列，要求根据26个字母的编号来将其转成字符串,返回所有可能种类
    // 例如 ‘111‘ --> 'AAA' or 'AK' or 'KA' 返回 3
    // 思路: 实际上是二叉树的分支(str[i] == '1' or str[i] == '2')
    // 因为只有26个字母，所以要么是 i 位置单独转化成字母
    // 要么是 i 和 i + 1 【 如果str[i] == ’2‘，0 < i + 1 < 6 】位置共同转化成一个位置

    public static int number(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        return process(str.toCharArray(),0);
    }

    public static int process(char[] str,int i){
        if(i == str.length){ // 中
            // 包含情况是 1. i == 0 时，数字序列为空，此时可以构成空串！！返回 1
            // 2. i 到达终止位置，就返回 1（子问题的终止条件）
            return 1;
        }
        // i 没有到终止位置时
        if(str[i] == '0'){ // 特殊情况
            return 0; // 两种情况:
            // 1. ’0‘ 在首时(母过程)，数字序列’012‘，i 指针指向第一个位置时为0，直接不进入递归，返回 0 种可能
            // 2. ’0‘ 在中时(子过程)，数字序列’110‘，i 指针指向第二个位置进行 i 和 i + 1 的转化时正确，这里不执行，如果i指针指向第三个位置为 0，直接不进入递归，返回 0 种可能
        }
        // str[i]字符是’1‘的情况: 又分成两种情况: 1. i 位置元素单独转换， 2. i 位置和 i + 1 位置共同转换
        if(str[i] == '1'){ // 两种情况相互嵌套，不会少算漏算
            int res = process(str,i + 1); // 1. i 位置元素单独转换
            if(i + 1 < str.length){
                res += process(str,i + 2); // 2. i 位置和 i + 1 位置共同转换,然后i + 2 位置再继续递归
            }
            return res;
        }
        // str[i]字符是’2‘的情况
        if(str[i] == '2'){
            int res = process(str,i + 1); // 左
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str,i + 2); // 右
            }
            return res;
        }
        // str[i] == '3' ~ '9'
        return process(str,i + 1);
    }
}
