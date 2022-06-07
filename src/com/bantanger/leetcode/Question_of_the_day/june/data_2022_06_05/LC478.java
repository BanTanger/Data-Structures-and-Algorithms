package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_05;

import java.util.Random;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/5 21:23
 */
public class LC478 {
    class Solution {
        Random random = new Random();
        double radius;
        double x_center;
        double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            while (true) {
                // 在一个正方形里进行随机取值，如果发现在正方向外部就再次随机
                double random_x = random.nextDouble() * (radius * 2) - radius;
                double random_y = random.nextDouble() * (radius * 2) - radius;
                if (random_x * random_x + random_y * random_y <= radius * radius) {
                    return new double[]{random_x + x_center, random_y + y_center};
                }
            }
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
}
