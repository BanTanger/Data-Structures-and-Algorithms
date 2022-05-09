package com.bantanger;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/9 18:27
 */
public class ThreadSleepSort {
    public void ThreadSleepSortTest(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            new Thread(()-> {
                try {
                    sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(num + " ");
            }).start();
        }
    }
    @Test
    public void test(){
        int[] nums = {1,4,2,9,3,5};
        new ThreadSleepSort().ThreadSleepSortTest(nums);
    }
}
