package com.bantanger.leetcode.prefix_array;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/12 14:03
 */
public class StudentScore {

    public int findScore(int[] count, int left, int right){
        return count[right + 1] - count[left];
    }

    @Test
    public void test(){
        int counts = 0;
        int[] scores = new int[100]; // 存放所有同学的分数
        int[] count = new int[100 + 1];
        Random random = new Random();
        for (int i = 0; i < scores.length; i++) {
//            scores[i] = random.nextInt(99) + 1;
            scores[i] = i;
            if(scores[i] >= 2 && scores[i] <= 20) {
                counts++;
                System.out.print(scores[i] + " ");
            }
        }
        System.out.println(" 总共有: " + counts);
        System.out.println();
        for (int score : scores) {
            count[score]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        System.out.println(findScore(count, 2,20));
    }

}
