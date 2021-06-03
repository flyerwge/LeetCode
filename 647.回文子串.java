/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += count(s, i, i); // 奇数
            count += count(s, i, i + 1); // 偶数
        }

        return count;

    }

    public int count(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }

        }

        return count;
    }
}
// @lc code=end
