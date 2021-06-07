import javax.swing.tree.TreeNode;

import org.graalvm.compiler.nodes.calc.RightShiftNode;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // int ans = 0;
        if (root == null) {
            return 0;
        }
        return pathSumStart(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    public int pathSumStart(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int count = root.val == sum ? 1 : 0;
        count += pathSumStart(root.left, sum - root.val);
        count += pathSumStart(root.right, sum - root.val);

        return count;
    }
}
// @lc code=end
