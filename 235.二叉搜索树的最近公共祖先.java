import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestNode = root;

        while (true) {
            if (ancestNode.val > p.val && ancestNode.val > q.val) {
                ancestNode = ancestNode.left;
            } else if (ancestNode.val < p.val && ancestNode.val < q.val) {
                ancestNode = ancestNode.right;
            } else {
                break;
            }
        }

        return ancestNode;

    }
}
// @lc code=end
