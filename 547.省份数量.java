/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int circles = 0;
        boolean[] isVisited = new boolean[provinces];

        for (int i = 0; i < provinces; i++) {
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, provinces, i);
                circles++;
            }

        }

        return circles;
    }

    /**
     * 朋友圈思想
     * 
     * @param isConnected
     * @param isVisited
     * @param provinces
     * @param i
     */
    private void dfs(int[][] isConnected, boolean[] isVisited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                dfs(isConnected, isVisited, provinces, j);
            }
        }
    }

}
// @lc code=end
