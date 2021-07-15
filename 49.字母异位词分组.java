import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>();

        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = new String(strChar);
            List<String> list = strMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            strMap.put(key, list);
        }

        for (Map.Entry<String, List<String>> entry : strMap.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;

    }
}
// @lc code=end
