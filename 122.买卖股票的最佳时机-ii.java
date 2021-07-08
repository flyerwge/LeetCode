/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dpProfit = new int[n];
        int[] dpState = new int[n];
        dpProfit[0] = 0;
        dpState[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 第i天卖出股票获得最大利润
            dpProfit[i] = Math.max(dpProfit[i - 1], dpState[i - 1] + prices[i]);
            // 第i天买入股票损失最小利润
            dpState[i] = Math.max(dpState[i - 1], dpProfit[i - 1] - prices[i]);
        }

        return dpProfit[n - 1];

    }
}
// @lc code=end
