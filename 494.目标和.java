/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int bag = (sum + target) / 2;
        int[] dp = new int[bag + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = bag; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[bag];
    }
}
// @lc code=end
