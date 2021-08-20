import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, track, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, LinkedList<Integer> track, int target, int index) {
        if (target == 0) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                track.add(candidates[i]);
                // i如果没有加1 ，某些数会重复使用
                backtrack(candidates, track, target - candidates[i], i + 1);
                track.removeLast();
            }
        }
    }
}
// @lc code=end
