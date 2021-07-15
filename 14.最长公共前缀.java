/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String ans = strs[0];
        char[] strChar = ans.toCharArray();

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < Math.min(ans.length(), strs[i].length()); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    ans = ans.substring(0, j);
                    break;
                }
            }

            ans = ans.substring(0, Math.min(ans.length(), strs[i].length()));

        }

        return ans;

    }
}
// @lc code=end
