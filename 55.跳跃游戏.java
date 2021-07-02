/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int remoteLocation = 0; // 能跳到的最远位置
        for (int i = 0; i < n; i++) {
            if (i <= remoteLocation) {
                remoteLocation = Math.max(remoteLocation, i + nums[i]);
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
