/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        boolean ans = true;

        String xStr = String.valueOf(x);
        int left = 0, right = xStr.length() - 1;
        while (left < right) {
            if (xStr.charAt(left) == xStr.charAt(right)) {
                left++;
                right--;
            } else {
                ans = false;
                break;
            }
        }

        return ans;
    }
}
// @lc code=end
