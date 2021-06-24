import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < nums.length - 2; first++) {
            int left = first + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[first] + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (nums[first] + nums[left] + nums[right] < 0) {
                    left++;
                }
                if (nums[first] + nums[left] + nums[right] == 0 && left < right) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if (ans.contains(list)) {
                        left++;
                        continue;
                    }
                    ans.add(list);
                    left++;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
