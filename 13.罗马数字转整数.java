import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> charOfNumMap = new HashMap<>();
        charOfNumMap.put('I', 1);
        charOfNumMap.put('V', 5);
        charOfNumMap.put('X', 10);
        charOfNumMap.put('L', 50);
        charOfNumMap.put('C', 100);
        charOfNumMap.put('D', 500);
        charOfNumMap.put('M', 1000);

        int sum = 0;
        int preNum = charOfNumMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (preNum < charOfNumMap.get(s.charAt(i))) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = charOfNumMap.get(s.charAt(i));
        }

        return sum + preNum;

    }
}
// @lc code=end
