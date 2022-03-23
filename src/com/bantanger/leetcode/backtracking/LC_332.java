package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/23 14:46
 */
public class LC_332 {
    class Solution {
        private Deque<String> res;
        private Map<String, Map<String, Integer>> map;

        private boolean backTracking(int ticketNum) {
            if (res.size() == ticketNum + 1) { // 只要达到了 (票数 + 1)，就代表找到了一个行程,两点成一线
                return true;
            }
            String last = res.getLast();
            if (map.containsKey(last)) { // 防止出现null
                for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                    int count = target.getValue();
                    if (count > 0) { // 记录到达的机场是否已经飞过
                        res.add(target.getKey()); // 结果列表中添加这个机场名称
                        target.setValue(count - 1); // 目标列表中这个机场的票数减少一次，减到0就不飞这个机场
                        if (backTracking(ticketNum)) return true; // 找到目标机场就直接结果，没找到就执行下面的回溯
                        res.removeLast(); // 回溯
                        target.setValue(count); // 恢复这个机场的票数
                    }
                }
            }
            return false;
        }

        public List<String> findItinerary(List<List<String>> tickets) {
            map = new HashMap<String, Map<String, Integer>>(); // 创建map记录映射关系
            // map<出发机场,map<到达机场,航班次数>>
            // Map里的元素要及时删除，不然出发机场和到达机场会导致重复，无法判断机场是否被使用过
            // 使用航班次数来做增减标记机场是否被使用过
            // 如果次数大于零，说明目的地还可以起飞，如果等于零就不能起飞
            res = new LinkedList<>();
            for (List<String> t : tickets) { // 遍历条件列表
                Map<String, Integer> temp;
                if (map.containsKey(t.get(0))) { // map存在该Key值
                    temp = map.get(t.get(0));
                    temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1); // 记录映射关系
                } else { // map不存在该Key值
                    temp = new TreeMap<>();//升序Map
                    temp.put(t.get(1), 1); // 初始化该目的地，票数为1
                }
                map.put(t.get(0), temp); // 构成映射关系
            }
            res.add("JFK");
            backTracking(tickets.size());
            return new ArrayList<>(res);
        }
    }

    @Test
    public void Test(){
        List<List<String>> tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));

        new Solution().findItinerary(tickets);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] nums = new int[m][n];
            for(int i = 0;i<m;i++){
                for(int j = 0;j < n ; j++){
                    nums[i][j] = scanner.nextInt();
                }
            }
            //List<Integer> result =
        }
    }
}
