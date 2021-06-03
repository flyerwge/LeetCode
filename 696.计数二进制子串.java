/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += count01(s, i, i + 1);
            count += count10(s, i, i + 1);
        }

        return count;

    }

    public int count01(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == '0' && s.charAt(right) == '1') {
                count++;
                right++;
                left--;
            } else {
                break;
            }
        }

        return count;
    }

    public int count10(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == '1' && s.charAt(right) == '0') {
                count++;
                right++;
                left--;
            } else {
                break;
            }
        }

        return count;
    }
}
// @lc code=end
