import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // int column = s.length() / ((numRows - 1) * 2) * (numRows - 1);
        // char[][] sChar = new char[numRows][column];

        // for (int i = 0; i < s.length(); i++) {

        // }

        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                flag = !flag;
            }
            curRow += flag ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }

        return ans.toString();
    }
}
// @lc code=end
