import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> targetCom = new LinkedList<>();
        backtrack(0, candidates, targetCom, target);
        return ans;

    }

    // 搜索起始加begin，防止结果重复
    public void backtrack(int begin, int[] candidates, LinkedList<Integer> targetCom, int target) {
        // 结束条件
        if (listSum(targetCom) == target) {
            LinkedList<Integer> temp = new LinkedList<>(targetCom);
            if (!ans.contains(temp)) {
                ans.add(temp);
                return;
            }
        } else if (listSum(targetCom) < target) {
            for (int i = begin; i < candidates.length; i++) {
                targetCom.add(candidates[i]);
                backtrack(i, candidates, targetCom, target);
                targetCom.removeLast();
            }
        }
    }

    public int listSum(LinkedList<Integer> targetCom) {
        int sum = 0;
        for (Integer integer : targetCom) {
            sum += integer;
        }
        return sum;
    }
}
// @lc code=end
