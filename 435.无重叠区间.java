/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        intervals = mulSort(intervals, 1);

        int preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < preEnd) {
                ans++;
            } else {
                preEnd = intervals[i][1];
            }
        }

        return ans;

    }

    // 多维数组根据某一列值选择排序
    public int[][] mulSort(int[][] intervals, int index) {
        int row = intervals.length;
        // int col = intervals[0].length;

        for (int i = 0; i < row; i++) {
            int min = i;
            for (int j = i + 1; j < row; j++) {
                if (intervals[j][1] < intervals[min][1]) {
                    min = j;
                }

            }

            int[] temp = intervals[i];
            intervals[i] = intervals[min];
            intervals[min] = temp;
        }

        return intervals;
    }
}
// @lc code=end
