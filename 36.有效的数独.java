import java.lang.management.MemoryManagerMXBean;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        // 验证每一行是否符合条件
        for (int i = 0; i < n; i++) {
            Set<Character> setRow = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!setRow.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        // 验证每一列是否符合条件
        for (int j = 0; j < n; j++) {
            Set<Character> setCol = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '.') {
                    if (!setCol.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        // 验证每一单元矩阵是否符合条件
        for (int sign = 0; sign < n; sign++) {
            Set<Character> setUnitBoard = new HashSet<>();
            int unitRow = (sign % 3) * 3;
            int unitCol = (sign / 3) * 3;

            for (int i = unitRow; i < unitRow + 3; i++) {
                for (int j = unitCol; j < unitCol + 3; j++) {
                    if (board[i][j] != '.') {
                        if (!setUnitBoard.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }

            char[][] unitBoard = new char[3][3];
        }

        return true;

    }
}
// @lc code=end
