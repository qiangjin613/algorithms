package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-string-ii/">543. 二叉树的直径</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_543 {

    int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return ans - 1;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = traverse(root.left);
        int r = traverse(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_543().diameterOfBinaryTree(new TreeNode(
                1,
                new TreeNode(2, 4, 5),
                new TreeNode(3)
        )));

        System.out.println(new Solution_543().diameterOfBinaryTree(new TreeNode(
                1,
                new TreeNode(2),
                null
        )));
        System.out.println(new Solution_543().diameterOfBinaryTree(new TreeNode(1)));
        System.out.println(new Solution_543().diameterOfBinaryTree(new TreeNode(
                2,
                new TreeNode(3,
                        new TreeNode(1),
                        null),
                null)));
    }
}
