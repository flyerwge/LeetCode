import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            hashChar.put(schar, hashChar.getOrDefault(schar, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char tchar = t.charAt(i);
            hashChar.put(tchar, hashChar.getOrDefault(tchar, 0) - 1);
            if (hashChar.get(tchar) < 0) {
                return false;
            }
        }

        return true;

    }
}
// @lc code=end
