import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumClosest = Integer.MAX_VALUE;
        int minGap = Integer.MAX_VALUE;

        for (int first = 0; first < nums.length - 2; first++) {
            int left = first + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[first] + nums[left] + nums[right];
                if (temp > target) {
                    right--;
                }
                if (temp < target) {
                    left++;
                }

                if (temp == target) {
                    return target;
                }

                if (Math.abs(temp - target) < minGap) {
                    minGap = Math.abs(temp - target);
                    sumClosest = temp;
                }
            }
        }

        return sumClosest;
    }
}
// @lc code=end
