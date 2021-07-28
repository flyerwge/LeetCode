/*
 * @lc app=leetcode.cn id=1736 lang=java
 *
 * [1736] 替换隐藏数字得到的最晚时间
 */

// @lc code=start
class Solution {
    public String maximumTime(String time) {
        StringBuilder ans = null;
        char[] timeChar = time.toCharArray();

        if (timeChar[0] == '?') {
            // 当timeChar[1]为'?'时，不在范围内，则timeChar[0]取'2'
            timeChar[0] = (timeChar[1] >= '4' && timeChar[1] <= '9') ? '1' : '2';
        }
        if (timeChar[1] == '?') {
            timeChar[1] = timeChar[0] == '2' ? '3' : '9';
        }
        if (timeChar[3] == '?') {
            timeChar[3] = '5';
        }
        if (timeChar[4] == '?') {
            timeChar[4] = '9';
        }

        return new String(timeChar);
    }
}
// @lc code=end
