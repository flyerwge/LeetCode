import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isNum(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                        break;
                }
            }

        }

        return stack.pop();

    }

    public boolean isNum(String token) {
        return !("+".equals(token)) && !("-".equals(token)) && !("*".equals(token)) && !("/".equals(token));
    }
}
// @lc code=end
