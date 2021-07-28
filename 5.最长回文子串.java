/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        char[] charS = s.toCharArray();
        int maxLength = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int l = 2; l <= len; l++) {
            for (int left = 0; left <= len - l; left++) {
                int right = left + l - 1;
                if (charS[left] == charS[right]) {
                    if (right - left < 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1] ? true : false;
                    }
                } else {
                    dp[left][right] = false;
                }

                if (dp[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    begin = left;
                }
            }
        }

        return s.substring(begin, begin + maxLength);

    }
}
// @lc code=end
