import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ansList = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        int num = matrix.length * matrix[0].length;

        int leftToRight = left, rightToLeft = right;
        int topToBottom = top, bottomToTop = bottom;

        while (num > 0) {
            while (num > 0 && leftToRight <= right) {
                ansList.add(matrix[top][leftToRight++]);
                num--;
            }
            top++;
            topToBottom = top;

            while (num > 0 && topToBottom <= bottom) {
                ansList.add(matrix[topToBottom++][right]);
                num--;
            }
            right--;
            rightToLeft = right;

            while (num > 0 && rightToLeft >= left) {
                ansList.add(matrix[bottom][rightToLeft--]);
                num--;
            }
            bottom--;
            bottomToTop = bottom;

            while (num > 0 && bottomToTop >= top) {
                ansList.add(matrix[bottomToTop--][left]);
                num--;
            }
            left++;
            leftToRight = left;

        }

        return ansList;

    }
}
// @lc code=end
