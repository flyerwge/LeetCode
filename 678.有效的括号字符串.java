/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            left += s.charAt(i) == ')' ? -1 : 1;
            right += s.charAt(s.length() - 1 - i) == '(' ? -1 : 1;

            if (left < 0 || right < 0) {
                return false;
            }
        }

        return true;

    }
}
// @lc code=end
