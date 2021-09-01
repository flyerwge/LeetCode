/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSub = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        // 超时
        // for(int i = 0; i < nums.length; i++){
        // int sum = 0, count = 0;
        // for(int j = i; j < nums.length; j++){
        // sum += nums[j];
        // if(sum >= target){
        // minSub = Math.min(minSub, j-i+1);
        // }
        // }
        // }

        while (right < nums.length) {
            sum += nums[right++];

            while (sum >= target) {
                minSub = Math.min(minSub, right - left);
                sum -= nums[left++];
            }
        }

        return minSub == Integer.MAX_VALUE ? 0 : minSub;
    }
}
// @lc code=end
