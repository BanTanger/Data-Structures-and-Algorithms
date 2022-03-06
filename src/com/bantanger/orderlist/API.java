package com.bantanger.orderlist;

import java.util.TreeMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class API {
    /**
     * 有序表所有操作都是时间复杂度为O(logN),N为有序表含有的记录
     */
    public static void API() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        // void put (K key, V value) 将一个（key，value）记录加到表中，或者将key的记录加入更新成value
        treeMap.put(1, "123");
        treeMap.put(2, "你好");
        treeMap.put(3, "321");

        // V get（K key），根据给定的key，查询对应的value
        treeMap.get(1);
        treeMap.get(2);
        treeMap.get(3);

        // void remove (K key),移除key的记录
        treeMap.remove(1);

        // boolean containsKey(K key) 查询是否有key的记录
        System.out.println(treeMap.containsKey(1));

        // K firstKey() 返回所有键值排序中最左（最小）的那个
        treeMap.firstKey();

        // K lastKey() 返回所有键值排序中最右（最大）的那个
        treeMap.lastKey();

        // K floorKey(K key) 如果表中存过key，返回key，否则就返回所有键值排序结果中key的前一个
        treeMap.floorKey(1);

        // K ceilingKey(K key) 如果表中存过key，返回key，否则就返回所有键值排序结果中key的后一个
        treeMap.ceilingKey(1);
    }
}
