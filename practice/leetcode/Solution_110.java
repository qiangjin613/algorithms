package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_110 {

    public boolean isBalanced(TreeNode root) {
        return balanceFactor(root) >= 0;
    }

    /**
     * 遍历计算平衡因素（当子树不平衡时，整棵树就已经不平衡了）
     */
    private int balanceFactor(TreeNode curNode) {
        if (curNode == null) {
            return 0;
        }

        int left = balanceFactor(curNode.left);
        int right = balanceFactor(curNode.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_110().isBalanced(new TreeNode(
                2,
                new TreeNode(3, new TreeNode(3), new TreeNode(3, 1, 1)),
                new TreeNode(7))));
    }
}
