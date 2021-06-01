/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;

        int[][] temp = grid;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, temp));
                }
            }
        }

        return ans;
    }

    /**
     * 沉岛思想
     * 
     * @param i
     * @param j
     * @param temp：迭代输入沉岛后的矩阵
     * @return
     */
    private int dfs(int i, int j, int[][] temp) {
        if (i < 0 || j < 0 || i >= temp.length || j >= temp[0].length || temp[i][j] == 0) {
            return 0;
        }

        int num = 1;
        temp[i][j] = 0;
        num += dfs(i + 1, j, temp);
        num += dfs(i - 1, j, temp);
        num += dfs(i, j + 1, temp);
        num += dfs(i, j - 1, temp);
        return num;

    }
}
// @lc code=end
