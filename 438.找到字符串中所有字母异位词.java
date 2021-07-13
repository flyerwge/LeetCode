import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0; // 有效字符数

        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        while (right < s.length()) {
            if (pMap.containsKey(s.charAt(right))) {
                if (sMap.getOrDefault(s.charAt(right), 0) < pMap.get(s.charAt(right))) {
                    valid++;
                }
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (valid == p.length()) {
                // 窗口内所有字符均为有效字符，则恰为p的异位词
                if (right - left == valid - 1) {
                    ans.add(left);
                }

                if (pMap.containsKey(s.charAt(left))) {
                    if (sMap.get(s.charAt(left)) > pMap.get(s.charAt(left))) {
                        sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                        left++;
                        continue;
                    } else {
                        sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                        left++;
                        valid--;
                        continue;
                    }
                }

                left++;
            }

            right++;
        }

        return ans;

    }
}
// @lc code=end
