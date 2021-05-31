/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        int leftIndex = leftIndex(nums, target);
        int rightIndex = rightIndex(nums, target);

        if (leftIndex <= rightIndex) {
            ans[0] = leftIndex;
            ans[1] = rightIndex;
        }

        return ans;

    }

    // 查找左边索引
    public int leftIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    // 查找右边索引
    public int rightIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
// @lc code=end
