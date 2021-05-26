import java.util.Arrays;

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = nums[0];
        Arrays.sort(nums);

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
            } else {
                ans = nums[right];
            }
        }
        // for (int left = 0; left < nums.length; left++) {
        // for (int right = left + 1; right < nums.length; right++) {
        // if (nums[left] == nums[right]) {
        // ans = nums[left];
        // }
        // }
        // }

        return ans;

    }
}
// @lc code=end
