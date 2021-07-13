import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, windowLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 第一层循环，窗口右指针滑动
        while (right < s.length()) {
            if (tMap.containsKey(s.charAt(right))) {
                if (sMap.getOrDefault(s.charAt(right), 0) < tMap.get(s.charAt(right))) {
                    valid++;
                }
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }

            // 第二层循环，窗口左指针滑动
            while (valid == t.length()) {
                // 判断是否为最小窗口
                if (right - left < windowLen - 1) {
                    start = left;
                    windowLen = right - left + 1;
                }

                if (tMap.containsKey(s.charAt(left))) {
                    if (sMap.get(s.charAt(left)) > tMap.get(s.charAt(left))) {
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

        // substring：结束索引不包括
        return windowLen == Integer.MAX_VALUE ? "" : s.substring(start, start + windowLen);

    }
}
// @lc code=end
