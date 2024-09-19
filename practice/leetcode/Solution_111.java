package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 叶节点
        if (root.right == null && root.left == null) {
            return 1;
        }

        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);

        if (lDepth * rDepth != 0) {
            return Math.min(lDepth, rDepth) + 1;
        }
        return lDepth != 0 ? lDepth + 1 : rDepth + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_111().minDepth(new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, 15, 7))));

        System.out.println(new Solution_111().minDepth(new TreeNode(
                2,
                null,
                new TreeNode(3, null, new TreeNode(7)))));
    }
}
