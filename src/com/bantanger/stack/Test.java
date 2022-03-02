package com.bantanger.stack;

/**
 * @author wuyou
 */
public class Test {
    public static void main(String[] args) {
        // 测试运算
        String expression1 = "33+2+2*6-2";
        String expression2 = "7*22*2-5+1-5+3-4";
        String expression3 = "4/2*3-4*2-3-99";
        String expression4 = "1*1*1*3*2/3";
        String expression5 = "11*1*1*3*2/3";
        String expression6 = "1000*23";

        // 创建两个栈：数栈、符号栈
        ListStack1 numStack = new ListStack1(10);
        ListStack1 operationStack = new ListStack1(10);

        test(expression1, numStack, operationStack);
        test(expression2, numStack, operationStack);
        test(expression3, numStack, operationStack);
        test(expression4, numStack, operationStack);
        test(expression5, numStack, operationStack);
        test(expression6, numStack, operationStack);
    }

    /**
     * 测试方法，测试表达式的结果，并且打印结果
     * @param expression 表达式
     * @param numStack 数字栈
     * @param operationStack 符号栈
     */
    public static void test(String expression, ListStack1 numStack, ListStack1 operationStack) {
        // 用于扫描
        int index = 0;
        // 将每次扫描得到的char保存到ch
        char ch = ' ';

        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression的每一个字符
            ch = getCharByIndex(expression, index);
            // 判断ch是什么，然后做相应的处理
            if (isOperation(ch)) {
                // 运用管道过滤器风格，处理运算符
                operationSolve1(ch, numStack, operationStack);
            } else {
                // 数直接入数栈，对值为ASCII值-48
                // 当处理多位数时候，不能立即入栈，可能是多位数，调用过滤器处理多位数
                index = numSolve1(expression, index, numStack);
            }
            // 让index+1，并判断是否扫描到expression最后
            index++;
            if (index >=  expression.length()) {
                break;
            }
        }
        // 最后只剩下两个数和一个运算符
        int res = cal((int) numStack.pop(), (int) numStack.pop(), (char) operationStack.pop());
        System.out.printf("表达式: %s = %d\n", expression, res);
    }

    /**
     * 获取表达式的下标位置为index的字符
     * @param expression 表达式
     * @param index 下标
     * @return
     */
    public static char getCharByIndex(String expression, int index) {
        return expression.charAt(index);
    }

    /**
     * 处理数字入栈的情况，包含处理多位数的情况，并且返回到操作表达式当前的下标
     * @param expression 表达式
     * @param index 下标
     * @param numStack 数字栈
     * @return 新的下标
     */
    public static int numSolve1(String expression, Integer index, ListStack1 numStack) {
        int end = index + 1;
        for (; end < expression.length(); end++) {
            char ch = getCharByIndex(expression, end);
            // 判断是不是数字
            if (!isOperation(ch)) {
                continue;
            } else {
                break;
            }
        }
        String numStr = expression.substring(index, end);
        // 数据入栈
        numStack.push(Integer.valueOf(numStr));
        // 因为test函数进行了+1，所以这里进行-1，避免给重复添加
        return end - 1;
    }

    /**
     * 符号过滤器1，判断当前是否具有字符
     * @param ch 运算符
     * @param numStack 数字栈
     * @param operationStack 运算符栈
     */
    public static void operationSolve1(char ch, ListStack1 numStack, ListStack1 operationStack) {
        // 判断当前符号栈是否具有操作符
        if (!operationStack.isEmpty()) {
            operationSolve2(ch, numStack, operationStack);
            return;
        } else {
            operationStack.push(ch);
            return;
        }
    }

    /**
     * 符号过滤器2，处理字符优先级，递归调用过滤器1
     * @param ch 运算符
     * @param numStack 数字栈
     * @param operationStack 运算符栈
     */
    public static void operationSolve2(char ch, ListStack1 numStack, ListStack1 operationStack) {
        // 比较优先级
        if (priority(ch) <= priority((Character) operationStack.peek())) {
            // 调用过滤器3进行计算
            operationSolve3(numStack,operationStack);
            // 递归调用过滤器1，不能递归调用过滤器2，因为可能存在当前运算符栈为空的情况
            operationSolve1(ch, numStack, operationStack);
            return;
        } else {
            // 直接将运算符加入到运算符栈中
            operationStack.push(ch);
            return;
        }
    }

    /**
     * 符号过滤器3，进行运算
     * @param numStack 数字栈
     * @param operationStack 运算符栈
     */
    public static void operationSolve3(ListStack1 numStack, ListStack1 operationStack) {
        // 定义相关变量
        int num1 = (int) numStack.pop();
        int num2 = (int) numStack.pop();
        char operation = (char) operationStack.pop();
        int res = cal(num1, num2, operation);
        // 把运算结果加到数栈
        numStack.push(res);
        return;
    }

    /**
     * 返回运算符的优先级，数字越大，运算符越高
     * @param operation 运算符
     * @return
     */
    public static int priority(char operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            // 假设目前的表达式只有 + - * /
            return -1;
        }
    }

    /**
     * 判断是不是运算符
     * @param val 字符
     * @return 是不是运算符
     */
    public static boolean isOperation(char val) {
        return val == '+' || val == '-' || val =='*' || val == '/';
    }

    /**
     * 计算结果
     * @param num1 操作数1，先出栈的数
     * @param num2 操作数2，后出栈的数
     * @param operation 操作符
     * @return 计算结果
     */
    public static int cal(int num1, int num2, char operation) {
        // 用于存放运算的结果
        int res = 0;
        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                // num1是先弹出来的数，为被减数
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                // num1是先弹出来的数，为被除数
                res = num2 / num1;
            default:
                break;
        }
        return res;
    }
}

/**
 * 表示链表的一个节点
 */
class Node1{
    Object element;
    Node1 next;

    public Node1(Object element) {
        this(element, null);
    }

    /**
     * 头插法插入节点
     * @param element 新增节点的value
     * @param n 原来的头节点
     */
    public Node1(Object element, Node1 n) {
        this.element = element;
        next = n;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }
}

/**
 * 用链表实现堆栈
 */
class ListStack1 {
    /**
     * 栈顶元素
     */
    Node1 header;
    /**
     * 栈内元素个数
     */
    int elementCount;
    /**
     * 栈的大小
     */
    int size;

    /**
     * 构造函数，构造一个空的堆栈
     */
    public ListStack1() {
        header = null;
        elementCount = 0;
        size = 0;
    }

    /**
     * 通过构造器 自定义栈的大小
     * @param size 栈的大小
     */
    public ListStack1(int size) {
        header = null;
        elementCount = 0;
        this.size = size;
    }

    /**
     * 设置堆栈大小
     * @param size 堆栈大小
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 设置栈顶元素
     * @param header 栈顶元素
     */
    public void setHeader(Node1 header) {
        this.header = header;
    }

    /**
     * 获取堆栈长度
     * @return 堆栈长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回栈中元素的个数
     * @return 栈中元素的个数
     */
    public int getElementCount() {
        return elementCount;
    }

    /**
     * 判断栈是否为空
     * @return 如果栈是空的，返回真，否则，返回假
     */
    public boolean isEmpty() {
        if (elementCount == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断栈满
     * @return 如果栈是满的，返回真，否则，返回假
     */
    public boolean isFull() {
        if (elementCount == size) {
            return true;
        }
        return false;
    }

    /**
     * 把对象入栈
     * @param value 对象
     */
    public void push(Object value) {
        if (this.isFull()) {
            throw new RuntimeException("Stack is Full");
        }
        header = new Node1(value, header);
        elementCount++;
    }

    /**
     * 出栈，并返回被出栈的元素
     * @return 被出栈的元素
     */
    public Object pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Object obj = header.getElement();
        header = header.getNext();
        elementCount--;
        return obj;
    }

    /**
     * 返回栈顶元素
     * @return 栈顶元素
     */
    public Object peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return header.getElement();
    }
}
