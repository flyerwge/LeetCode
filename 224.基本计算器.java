import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
/**
 * 计算器模板： 1. 把所有的运算都看成加法，无非是加正数和加负数的问题 2. 遇到乘除法，原地计算一个新的被加数 3. 遇到括弧就原地得到一个新的整数
 */
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (c == '(') {
                int j = findClosing(s.substring(i));
                num = calculate(s.substring(i + 1, i + j));
                i += j;
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                preSign = c;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;

    }

    public int findClosing(String s) {
        int level = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                level++;
            } else if (s.charAt(i) == ')') {
                level--;
                if (level == 0) {
                    ans = i;
                    break;
                }
            }
        }

        return ans;
    }

}
// @lc code=end
