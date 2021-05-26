import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft,
            int inorderRight) {

        if (preorderLeft > preorderRight) {
            return null;
        }

        int preorderRoot = preorderLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        TreeNode root = new TreeNode(preorder[preorderRoot]);

        int leftSubTreeSize = inorderRoot - inorderLeft;
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubTreeSize, inorderLeft,
                inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder, preorderLeft + leftSubTreeSize + 1, preorderRight, inorderRoot + 1,
                inorderRight);

        return root;

    }
}
// @lc code=end
