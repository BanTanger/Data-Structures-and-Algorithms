package com.bantanger.queue;


/**
 * @author bantanger 半糖
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayQueueDemo {
    public static void main(String[] args) {

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
        int front = -1;
        int rear = -1;
        int[] arr = new int[maxSize];
    }

    // 判断数组是否满
    public boolean isFull(){
        return rear < maxSize -1;
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
            System.out.print(arr[i] + '\t');
        }
    }
}