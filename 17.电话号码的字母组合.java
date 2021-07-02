import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> tracks = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder track = new StringBuilder();
        if (digits.length() == 0) {
            return tracks;
        }

        // 哈希表存储字母与数字对应关系
        Map<Character, String> numMap = new HashMap<>();
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");

        backpack(numMap, digits, 0, track);
        return tracks;

    }

    // 回溯
    public void backpack(Map<Character, String> numMap, String digits, int index, StringBuilder track) {
        // 触发结束条件
        if (index == digits.length()) {
            tracks.add(track.toString());
            return;
        }

        char digit = digits.charAt(index);
        String leters = numMap.get(digit);

        for (int i = 0; i < leters.length(); i++) {
            track.append(leters.charAt(i));
            backpack(numMap, digits, index + 1, track);
            track.deleteCharAt(index);
        }

    }
}
// @lc code=end
