package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-distance-between-bst-nodes/">783. 二叉搜索树节点最小距离</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_783 {

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return ans;
    }

    private int lastVal = -1;
    private int ans = Integer.MAX_VALUE;

    /**
     * BST 的中序遍历的数据是顺序递增的
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        int curVal = Math.abs(root.val - lastVal);
        if (lastVal != -1 && curVal < ans) {
            ans = curVal;
        }
        lastVal = root.val;

        traverse(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_783().minDiffInBST(new TreeNode(
                5,
                1,
                7
        )));
        System.out.println(new Solution_783().minDiffInBST(new TreeNode(
                4,
                new TreeNode(2, 1, 3),
                new TreeNode(6)
        )));
    }
}
