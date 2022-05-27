package com.bantanger.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/27 15:34
 */
public class LC350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
            for (int num : nums1) {
                Integer count = map.get(num);
                if (count == null) {
                    map.put(num, 1);
                } else {
                    map.put(num, ++count);
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int num : nums2) {
                Integer count = map.get(num);
                if (count != null && count != 0) {
                    list.add(num);
                    map.put(num, --count);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
