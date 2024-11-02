package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/range-sum-of-bst/">938. 二叉搜索树的范围和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int curVal = 0;
        if (root.val >= low && root.val <= high) {
            curVal = root.val;
        }
        int leftSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);
        return leftSum + rightSum + curVal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_938().rangeSumBST(
                new TreeNode(10,
                        new TreeNode(5, 3, 7),
                        new TreeNode(15,
                                null,
                                new TreeNode(18))),
                7, 15));
    }
}
