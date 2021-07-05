/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = nums.length;
        int targetPosition = -1;

        for (int i = 0; i < l; i++) {
            if (nums[i] == target) {
                targetPosition = i;
                break;
            }
        }

        return targetPosition;
    }
}
// @lc code=end
