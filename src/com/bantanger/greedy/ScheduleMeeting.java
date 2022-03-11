package com.bantanger.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SplittableRandom;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class ScheduleMeeting {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 计算一个集合中的会议怎么在一天之内安排最合理。
     * @param programs 所有会议的集合
     * @param timePoint 会议开始时间
     * @return
     */
    public static int bestArrange(Program[] programs,int timePoint){
        int result = 0;
        // 对会议的结束时间进行排序，依据结束时间定先后顺序
        Arrays.sort(programs,new Comparator<Program>(){
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });
        for (int i = 0; i < programs.length; i++) {
            if(timePoint <= programs[i].start){
                // 如果会议开始的时间点比排序后的数组会议开始时间点早，就直接进入
                result++;
                timePoint = programs[i].end; // 更改时间点
            }
        }
        return result;
    }
}
