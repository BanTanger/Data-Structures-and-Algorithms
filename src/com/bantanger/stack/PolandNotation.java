package com.bantanger.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "1+((20+3)*4)/5";
        // 将字符串写入到一个ArrayList集合中，方便遍历
        List<String> infixExpressionList = toInfixExpressionList(suffixExpression);
        System.out.println("中缀表达式对应的List" + infixExpressionList);
        System.out.println("------------------------------------------");
        List<String> parsePostfixExpression = parsePostfixExpression(infixExpressionList);
        System.out.println("后缀表达式对应的List" + parsePostfixExpression);
        System.out.println("------------------------------------------");
        System.out.println("最终计算的结果是:" + calculate(parsePostfixExpression));
    }

    /**
     * 将存放中缀表达式的ArrayList转换成后缀表达式
     * @param ls 存放中缀表达式的ArrayList集合
     * @return 返回存有后缀表达式的List
     */
    public static List<String> parsePostfixExpression(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>(); // 符号栈s1
//        Stack<String> s2 = new Stack<>(); // 储存中间结果的栈s2
        //实际上没有用到s2这个栈，因为整个存储过程都是push到s2，并没有在过程中pop，
        // 而最后要拿到s2的数据要需要逆序操作，所以就很麻烦 ， 干脆使用List<String> s2来代替栈s2
        List<String> s2 = new ArrayList<String>(); // 存储中间结果的Lists2

        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，加入s2
            if (item.matches("\\d+")){ // 匹配数字，正则表达式，\d表示匹配一位数，\d+表示匹配多位数
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                // 如果是右括号 ” ) “ , 则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，将这对括号丢弃
                while(!s1.peek().equals("(")){ // 只是查看弹出值，并不是pop
                    s2.add(s1.pop());
                }
                s1.pop(); // 这时候弹出的是“（”
            } else {
                // 如果 item 优先级比栈顶的高，也将运算符压入s1
                // 如果 item 优先级比栈顶的低(小于等于)，将s1栈顶的运算符弹出并压入s2中，再次跳转到4-1的步骤，与s1中新的栈顶运算符进行比较
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop()); // 将s1的符号取出加入s2
                }
                s1.push(item);
            }
        }
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 将中缀表达式中的每一个字符存放到一个ArrayList集合中
     * @param suffixExpression 放入中缀表达式
     * @return 返回ArrayList
     */
    public static List<String> toInfixExpressionList(String suffixExpression) {
        // 定义一个List存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int index = 0; // 指针，用于遍历 中缀表达式字符串
        String str; // 对多位数进行拼接
        char c; // 遍历每一个字符，存放到c里面
        do {
            // 如果字符串是一个非数字的。放入 ls 之中
            if ((c = suffixExpression.charAt(index)) < '0'
                    || (c = suffixExpression.charAt(index)) > '9') {
                ls.add("" + c);
                index++;
            } else { // 如果读到的字符是数字，需要循环遍历直到字符出现非数字（多位数处理）
                str = ""; // 将str置成零，每一次进入else条件就先置空str
                while (index < suffixExpression.length() &&
                        !((c = suffixExpression.charAt(index)) < '0'
                                || (c = suffixExpression.charAt(index)) > '9')) {
                    str += c;// 多位数拼接
                    index++;
                }
                ls.add(str);
            }
        } while (index < suffixExpression.length()); // 没有游走到传入字符串的最后一位，就一直读取
        return ls;
    }

    /**
     * 计算功能
     * @param ls 后缀表达式
     * @return 最终运算结果
     */
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")){ // 如果匹配的是多位数
                // 入栈
                stack.push(item);
            } else { // 匹配的是运算符
                // stack弹出两个数
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                // 将每一次运算的结果压入栈中
                stack.push(res + "");
            }
        }
        // 最后栈里只剩下一个数，就是最终答案，直接返回
        return Integer.parseInt(stack.pop());
    }
}

/**
 * 编写一个类Operation，返回一个运算符对应的优先级
 */
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0; // 括号不属于运算符，默认赋给0
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}

