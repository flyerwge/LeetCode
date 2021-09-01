/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int mul = 1, count = 0;

        while (right < nums.length) {
            mul *= nums[right++];

            while (left < right && mul >= k) {
                mul /= nums[left++];
            }
            count += right - left;
        }

        return count;
    }
}
// @lc code=end
