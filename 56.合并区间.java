import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 根据二维数组第一列将二维数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> mergedList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (mergedList.size() == 0 || mergedList.get(mergedList.size() - 1)[1] < left) {
                mergedList.add(intervals[i]);
            } else {
                mergedList.get(mergedList.size() - 1)[1] = Math.max(right, mergedList.get(mergedList.size() - 1)[1]);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);

    }
}
// @lc code=end
