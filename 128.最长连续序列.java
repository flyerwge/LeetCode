import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int stLength = 1, maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                stLength++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                maxLength = Math.max(stLength, maxLength);
                stLength = 1;
            }
        }

        return Math.max(stLength, maxLength);

    }
}
// @lc code=end
