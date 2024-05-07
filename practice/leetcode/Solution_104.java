package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 */
public class Solution_104 {

    /**
     * 解法一：通过分解问题计算答案的思路，一棵二叉树的最大深度可以通过子树的最大深度推导出来
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = traverse(root.left) + 1;
        int rightDepth = traverse(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        System.out.println(new Solution_104().maxDepth(treeNode));
    }
}
