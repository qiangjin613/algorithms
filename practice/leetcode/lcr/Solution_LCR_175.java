package leetcode.lcr;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/">LCR 175. 计算二叉树的深度</a>
 *
 * @see leetcode.Solution_104 104. 二叉树的最大深度
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_175 {

    public int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_LCR_175().calculateDepth(new TreeNode(
                7,
                new TreeNode(3, 1, 5),
                new TreeNode(9)
        )));
    }
}
