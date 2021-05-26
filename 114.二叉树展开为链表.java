import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        preOrder(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode preNode = list.get(i - 1);
            TreeNode curNode = list.get(i);
            preNode.left = null;
            preNode.right = curNode;
        }

    }

    public void preOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}
// @lc code=end
