/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        //索引i左边所有元素乘积
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int right = 1; //索引i右边所有元素乘积
        for(int i = n-1; i >=0; i--){
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;

    }
}
// @lc code=end

