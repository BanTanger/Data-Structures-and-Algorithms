#define _CRT_SECURE_NO_WARNINGS 1
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() < 2) return nums.size();
        int slowindex = 0;
        for (int fastindex = 1; fastindex < nums.size(); fastindex++) {
            if (nums[fastindex] != nums[slowindex] && fastindex != nums.size()) {
                nums[++slowindex] = nums[fastindex];
            }
        }
        return ++slowindex;
    }
};