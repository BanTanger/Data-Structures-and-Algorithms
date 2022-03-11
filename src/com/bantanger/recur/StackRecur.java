package com.bantanger.recur;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class StackRecur {
    /**
     * 功能：递归的获取当前子栈的最底层元素，将母问题时的栈顶元素压入栈底。
     * @param stack 当前子过程的栈
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) { // 终止条件，只要递归到栈空了，就结束
            return;
        }
        int i = f(stack); // 拿到子栈最底层的元素。
        reverse(stack);  // 递归调用上面过程，一直拿取当前子栈最底层的东西
        stack.push(i);
        // 执行到这一步的时候栈已经是空的了，然后将当前记录的i
        //（为最后执行子过程的i，也就是母问题的最顶层），压入栈中
    }

    /**
     * 功能：将栈底弹出返回，例如本来栈是 3 -> 2 -> 1 ，变成 3 -> 2 ，返回 1
     * @param stack 传入子过程的栈
     * @return 返回栈底元素
     */
    public static int f(Stack<Integer> stack) {
        int result = stack.pop(); // 把栈顶元素弹出保存
        if (stack.isEmpty()) {
            return result; // 如果弹出之后栈里没有元素，就直接返回弹出的结果
        } else {
            int last = f(stack); // 递归的调用f函数，拿到最低端的元素
            stack.push(result); // 将第二底层的元素压回栈里。
            return last; // 记录最底层元素返回 （每一个子过程都记录保存最低端元素）
        }
    }
}
