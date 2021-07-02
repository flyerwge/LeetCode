/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int end = 0;
        int maxPositiin = 0;

        // 不能访问最后一个位置，否则，当跳跃边界刚好是最后一个位置
        // 会增加一次不必要的跳跃
        for (int i = 0; i < n - 1; i++) {
            maxPositiin = Math.max(maxPositiin, i + nums[i]);
            if (i == end) {
                end = maxPositiin;
                steps++;
            }
        }

        return steps;

    }
}
// @lc code=end
