/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {

        int ans = -1;
        int window = needle.length();

        if (window == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int size = 0;
            ans = i;
            for (int j = i; j < i + window; j++) {
                if (haystack.charAt(i) != needle.charAt(size++)) {
                    ans = -1;
                }
            }
            if (ans != -1) {
                break;
            }

        }

        return ans;
    }
}
// @lc code=end
