package com.bantanger.stack;

import java.awt.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(5);
//        arrayStack.push(1);
//        arrayStack.push(2);
//        arrayStack.push(3);
//        arrayStack.push(4);
//        arrayStack.push(5);
//        arrayStack.show();

        String expression = "3-2*6-2+11";
        // 先进行字符串的截取
      /*  String[] num = expression.split("[\\+\\-\\*\\/]");
        int length = num.length;*/
//        System.out.println(num[0] + num[1] + num[2] + num[3]);
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        // 定义需要的相关变量
        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描得到的char保存到ch
        String keepNum = "";

        while (true) {
            // 依次得到expression每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch为什么，然后做相应处理
            if (operStack.isOper(ch)) { // 如果取出来的字符是符号
                if (!operStack.isEmpty()) { // 并且符号栈不为空
                    // 进行比较，判断将加入的符号和栈顶的符号优先级先后
                    // 情况一 ： 符号栈中的优先级比要加入的栈的符号优先级高，先执行符号栈里的符号运算
                    if (operStack.priority(operStack.peek()) >= operStack.priority(ch)) {
                        // 在数栈中弹出两个数
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        // 在符号栈中弹出一个符号
                        oper = operStack.pop();
                        // 进行计算，并将结果压入数栈中
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        // 最后将当前符号压入符号栈中
                        operStack.push(ch);
                        // 情况二 ： 符号栈中的优先级比要加入的栈的符号优先级低，直接将符号压入符号栈
                    } else {
                        operStack.push(ch);
                    }
                } else { // 符号栈为空，直接将字符压入
                    operStack.push(ch);
                }
            } else { // 如果取出来的字符是数据
                // 这里想想怎么样拿到两位数的数据
                // 用String的手段一直读，直到读到符号位停止，然后将String 转换成 Int类型。
                // 思路错误，他会一开始就走判断符号，所以没有办法存入呀
                // 2. 通过字符串分割拿到字符
                /*if (index < length){
                    numStack.push(Integer.parseInt(num[index]));
                }*/
//                numStack.push(ch - '0');
                // 处理多位数
                keepNum += ch;

                // 如果index已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) { // 字符串从零开始，当index移动到length就已经完成扫描
                break;
            }
        }

        // 当表达式扫描完毕，就按顺序从数栈和符号栈中pop出相应的数和符号，并运行
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            if (!operStack.isEmpty() && operStack.peek() == '-'){
                operStack.pop();
                num2 = -num2;
                operStack.push("+".charAt(0));
            }
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("表达式 " + expression + " 计算结果为 " + numStack.pop());
    }
}

class ArrayStack {
    public int[] stack;
    public int top;
    public int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    // 返回当前栈顶的值
    public int peek() {
        return stack[top];
    }

    // 判空函数
    public boolean isEmpty() {
        return top == -1;
    }

    // 判满函数
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 入栈 push
    public void push(int value) {
        //先判满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    // 出栈 pop
    public int pop() {
        // 先判空
        if (isEmpty()) {
            throw new RuntimeException("栈空，不能执行出栈操作");
        }
        int value = stack[top--];
        return value;
    }

    // 显示
    public void show() {
        if (isEmpty()) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[ " + i + " ]" + " = " + stack[i]);
        }
    }

    // 返回运算符的优先级，使用数字定义优先级
    // 数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断表达式中的符号
    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;// 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; // 注意弹出顺序，先弹出的作为被减数
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
