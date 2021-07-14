import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<Character>();
        int valid = 0, maxStrLength = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            if (charSet.contains(s.charAt(right))) {
                maxStrLength = Math.max(valid, maxStrLength);
                charSet.remove(s.charAt(left++));
                valid--;
            } else {
                charSet.add(s.charAt(right));
                right++;
                valid++;
            }
        }
        return Math.max(maxStrLength, valid);

    }
}
// @lc code=end
