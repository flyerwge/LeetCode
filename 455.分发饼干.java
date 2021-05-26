import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    // g:孩子胃口值
    // s:饼干尺寸大小
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }

            if (j < s.length) {
                count++;
            }

        }

        return count;

    }
}
// @lc code=end
