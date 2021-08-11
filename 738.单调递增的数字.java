/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] nChar = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < nChar.length && nChar[i - 1] <= nChar[i]) {
            i++;
        }

        if (i < nChar.length) {
            while (i > 0 && nChar[i - 1] > nChar[i]) {
                nChar[i - 1] -= 1;
                i--;
            }

            for (i += 1; i < nChar.length; i++) {
                nChar[i] = '9';
            }
        }

        return Integer.parseInt(new String(nChar));
    }
}
// @lc code=end
