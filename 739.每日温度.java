import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> deStack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!deStack.isEmpty() && temperatures[i] > temperatures[deStack.peek()]) {
                int index = deStack.pop();
                ans[index] = i - index;
            }
            deStack.push(i);
        }

        return ans;

    }
}
// @lc code=end
