/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;

    }
}
// @lc code=end
