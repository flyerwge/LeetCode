import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;

        // 想多了，双指针不合适
        // Arrays.sort(nums);

        // int left = 0, right = nums.length - 1;
        // while (left < right) {
        // if (nums[left] + nums[right] > target) {
        // right--;
        // }
        // if (nums[left] + nums[right] < target) {
        // left++;
        // }
        // if (nums[left] + nums[right] == target && left < right) {
        // ans[0] = left;
        // ans[1] = right;
        // break;
        // }
        // }

        // return ans;

    }
}
// @lc code=end
