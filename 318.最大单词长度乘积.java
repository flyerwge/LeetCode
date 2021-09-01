/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        // 超时
        // List<List<Character>> strList = new ArrayList<>();
        // int maxMul = 0;
        // for (int i = 0; i < words.length; i++) {
        // List<Character> list = new ArrayList<>();
        // for (int j = 0; j < words[i].length(); j++) {
        // list.add(words[i].charAt(j));
        // }
        // strList.add(list);
        // }

        // for (int i = 0; i < words.length; i++) {
        // label: for (int j = i + 1; j < words.length; j++) {
        // for (int k = 0; k < words[j].length(); k++) {
        // if (strList.get(i).contains(words[j].charAt(k))) {
        // continue label;
        // }
        // }
        // maxMul = Math.max(maxMul, words[i].length() * words[j].length());
        // }
        // }

        // return maxMul;

        int maxMul = 0;

        boolean[][] flag = new boolean[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                flag[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length; i++) {
            label: for (int j = i + 1; j < words.length; j++) {
                for (int k = 0; k < 26; k++) {
                    if (flag[i][k] && flag[j][k]) {
                        continue label;
                    }
                }

                maxMul = Math.max(maxMul, words[i].length() * words[j].length());

            }
        }

        return maxMul;
    }
}
// @lc code=end
