import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    // 动态规划
    public int coinChange(int[] coins, int amount) {
        // 非背包问题通用模板
        // int[] dp = new int[amount + 1];
        // Arrays.fill(dp, amount + 1);
        // dp[0] = 0;

        // for (int i = 1; i <= amount; i++) {
        // for (int j = 0; j < coins.length; j++) {
        // if (coins[j] <= i) {
        // dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        // }
        // }
        // }

        // return dp[amount] > amount ? -1 : dp[amount];

        // 背包问题通用模板
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end
