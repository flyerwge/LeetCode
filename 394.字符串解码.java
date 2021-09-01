/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack.push(num);
                num = 0;
                strStack.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curNum = stack.pop();
                for (int j = 0; j < curNum; j++) {
                    temp.append(stringBuilder);

                }
                stringBuilder = new StringBuilder(strStack.pop() + temp);
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();

    }
}
// @lc code=end
