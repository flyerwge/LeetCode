import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            set.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }

            q = parent.get(q.val);
        }

        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
// @lc code=end
