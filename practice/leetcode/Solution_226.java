package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">226. 翻转二叉树</a>
 */
public class Solution_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.right);
        invertTree(root.left);
        return swapNode(root);
    }

    private static TreeNode swapNode(TreeNode root) {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;

        TreeNode treeNode = new Solution_226().invertTree(root);
        System.out.println();
    }
}
