package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">530. 二叉搜索树的最小绝对差</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_530 {

    int mix = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;

    /**
     * 利用 "二叉搜索树中序遍历得到的值序列是递增有序" 特性
     */
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return mix;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        mix = Math.min(mix, Math.abs(root.val - pre));

        pre = root.val;
        traverse(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_530().getMinimumDifference(new TreeNode(
                4,
                new TreeNode(2, 1, 3),
                new TreeNode(6)
        )));
    }
}
