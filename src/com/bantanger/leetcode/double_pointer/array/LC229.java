package com.bantanger.leetcode.double_pointer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/30 17:08
 */
public class LC229 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            /*有一个对摩尔投票法非常形象的比喻：多方混战。

首先要知道，在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。

我们把这道题比作一场多方混战，战斗结果一定只有最多两个阵营幸存，其他阵营被歼灭。数组中的数字即代表某士兵所在的阵营。

我们维护两个潜在幸存阵营A和B。我们遍历数组，如果遇到了属于A或者属于B的士兵，则把士兵加入A或B队伍中，该队伍人数加一。继续遍历。

如果遇到了一个士兵既不属于A阵营，也不属于B阵营，这时有两种情况：

A阵营和B阵营都还有活着的士兵，那么进行一次厮杀，参与厮杀的三个士兵全部阵亡：A阵营的一个士兵阵亡，B阵营的一个士兵阵亡，这个不知道从哪个阵营来的士兵也阵亡。继续遍历。

A阵营或B阵营已经没有士兵了。这个阵营暂时从地球上消失了。那么把当前遍历到的新士兵算作新的潜在幸存阵营，这个新阵营只有他一个人。继续遍历。

大战结束，最后A和B阵营就是初始人数最多的阵营。判断一下A，B的人数是否超过所有人数的三分之一就行了。*/
            // 摩尔投票升级版
            // 在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。
            int n = nums.length;
            int a = 0, b = 0; // 记录两个候选人 （超过n / 3的人数最多只能2个）
            int c1 = 0, c2 = 0;  // 两个候选人票数
            for (int num : nums) {
                if (c1 != 0 && a == num) c1++;
                else if (c2 != 0 && b == num) c2++;
                else if (c1 == 0 && ++c1 >= 0) a = num;
                else if (c2 == 0 && ++c2 >= 0) b = num;
                else { // 如果出现第三者，所有候选人票数减一
                    c1--;
                    c2--;
                }
            }
            // 第二遍筛选
            c1 = 0;
            c2 = 0;
            for (int num : nums) {
                if (a == num) c1++;
                else if (b == num) c2++;
            }
            List<Integer> res = new ArrayList<>();
            if (c1 > n / 3) res.add(a);
            if (c2 > n / 3) res.add(b);
            return res;
        }
    }
}
