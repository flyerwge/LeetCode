/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count = dfs(grid, i, j) > 0 ? ++count : count;
                }
            }
        }

        return count;

    }

    /**
     * 沉岛思想
     * 
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        int num = 1;
        grid[i][j] = '0';
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i, j - 1);
        num += dfs(grid, i, j + 1);

        return num;
    }
}
// @lc code=end
