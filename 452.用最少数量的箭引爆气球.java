import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int ans = 1;

        // 将二维数组根据第二列升序排列
        // Arrays.sort(points, new Comparator<int[]>() {
        // public int compare(int[] a, int[] b) {
        // // 疑问：①为什么根据第一列排序不可以，根据第二列排序才可以
        // // 疑问：②下面两种写法有什么不同
        // // return a[1] - b[1];
        // if (a[1] > b[1]) {
        // return 1;
        // } else if (a[1] < b[1]) {
        // return -1;
        // } else {
        // return 0;
        // }
        // }
        // });

        int[] temp = points[0];

        for (int[] ball : points) {
            if (ball[0] > temp[1]) {
                ans++;
                temp = ball;
            }
        }

        return ans;

    }
}
// @lc code=end
