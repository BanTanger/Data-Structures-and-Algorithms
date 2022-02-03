#define _CRT_SECURE_NO_WARNINGS 1
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int slowindex = 0;
        for (int fastindex = 0; fastindex < nums.size(); fastindex++) {
            if (nums[fastindex] != 0) {
                // ½»»»²Ù×÷
                int tmp = nums[fastindex];
                nums[fastindex] = nums[slowindex];
                nums[slowindex++] = tmp;
            }
        }
    }
};