/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        String[] sArray = s.split(" ");
        return sArray.length == 0 ? 0 : sArray[sArray.length - 1].length();
    }
}
// @lc code=end
