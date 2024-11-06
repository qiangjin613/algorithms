package leetcode.lcr;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/">LCR 176. 判断是否为平衡二叉树</a>
 *
 * @see leetcode.Solution_110 110. 平衡二叉树
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_176 {

    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }

    /**
     * 如果是平衡二叉树则返回的是树的高度；否则，返回 -1
     */
    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = traverse(node.left);
        int rightHeight = traverse(node.right);

        if (leftHeight == -1 || rightHeight == -1 || (Math.abs(leftHeight - rightHeight) > 1)) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_LCR_176().isBalanced(new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(3, 4, 4),
                        new TreeNode(3)),
                new TreeNode(2)
        )));
    }
}
