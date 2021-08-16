/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] content = new int[strs.length][2];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            content[i] = getZeroOnes(strs[i]);
        }

        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= content[i][0]; j--) {
                for (int k = n; k >= content[i][1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - content[i][0]][k - content[i][1]]);
                }
            }
        }

        return dp[m][n];
    }

    public int[] getZeroOnes(String str) {
        int[] ans = new int[2];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                ans[0]++;
            } else {
                ans[1]++;
            }
        }

        return ans;
    }
}
// @lc code=end
