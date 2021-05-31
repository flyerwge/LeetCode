/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
// @lc code=end
