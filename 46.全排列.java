import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return ans;

    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            ans.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
// @lc code=end
