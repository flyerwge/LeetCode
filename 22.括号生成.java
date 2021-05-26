import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder brackets = new StringBuilder();
        backtrack(n, brackets, 0, 0);
        return ans;
    }

    public void backtrack(int n, StringBuilder brackets, int left, int right) {
        // 结束条件
        if (brackets.length() == n * 2) {
            ans.add(brackets.toString());
            return;
        }

        if (left < n) {
            brackets.append("(");
            backtrack(n, brackets, left + 1, right);
            brackets.deleteCharAt(brackets.length() - 1);
        }
        if (right < left) {
            brackets.append(")");
            backtrack(n, brackets, left, right + 1);
            brackets.deleteCharAt(brackets.length() - 1);
        }

    }
}
// @lc code=end
