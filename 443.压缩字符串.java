/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // 未在原地修改
        // Map<Character,Integer> map = new HashMap<>();
        // StringBuilder stringBuilder = new StringBuilder();

        // for(int i = 0; i < chars.length; i++){
        // map.put(chars[i],map.getOrDefault(chars[i], 0) + 1);
        // }

        // for(Map.Entry<Character,Integer> entry : map.entrySet()){
        // stringBuilder.append(entry.getKey());
        // stringBuilder.append(entry.getValue());
        // }

        // return stringBuilder.toString().length();

        int left = 0, right = 0, write = 0;
        while (right < chars.length) {
            int num = 0;
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
                num++;
            }

            chars[write++] = chars[left];
            left = right;

            if (num == 1) {
                continue;
            } else {
                String str = Integer.toString(num);
                char[] strChar = str.toCharArray();
                for (char c : strChar) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
// @lc code=end
