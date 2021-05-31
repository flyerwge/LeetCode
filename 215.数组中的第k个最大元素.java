/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        selectSort(nums);

        return nums[nums.length - k];

    }

    // // 快速排序
    // public int[] quickSort(int[] nums,int left,int right) {
    // if (nums.length < 2) {
    // return nums;
    // }

    // }

    // 选择排序
    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
// @lc code=end
