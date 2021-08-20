import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, track, 1);
        return res;
    }

    public void backtrack(int n, int k, LinkedList<Integer> track, int index) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = index; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }

            track.add(i);
            backtrack(n, k, track, i);
            track.removeLast();
        }
    }
}
// @lc code=end
