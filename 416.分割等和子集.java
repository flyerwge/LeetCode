/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            // 为什么这里必须要用--
            // 01背包问题，避免物体重复使用，从右向左计算
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[target] != 0;
    }
}
// @lc code=end
