package com.bantanger.queue;


import java.util.Scanner;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        String key = " "; // 接收用户接收
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            String next = scanner.next();
            key = next;
            switch (key){
                case "s":
                    arrayQueue.showQueue();
                    break;
                case "a":
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case "g":
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println("取出的数据:" + queue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "h":
                    try {
                        int i = arrayQueue.headQueue();
                        System.out.println("当前头节点数据:" + i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
@SuppressWarnings({"all"})
class ArrayQueue{
    private int maxSize; // 数组最大容量
    private int front; // 队列头部
    private int rear; // 队列尾部
    private int[] arr; // 该数据用于存放数据，模拟队列

    // 创建队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
       /* int front = -1;
        int rear = -1;*/
        arr = new int[this.maxSize];
    }

    // 判断数组是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    // 存入数据，入队列写法
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("队列已满，不能再写入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 获得数据，出队列写法
    public int getQueue(){
        if (isEmpty()){
            // 抛出异常而不是return -1；因为有可能要获取的值就是-1
            throw new RuntimeException("队列为空，不能取出数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue(){
        // 遍历
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front++]; // 一开始定义front为-1.如果想要读出数据必须让front有效
    }
}