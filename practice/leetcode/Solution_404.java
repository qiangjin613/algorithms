package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/">404. 左叶子之和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_404 {

    /**
     * 前序遍历
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        if (root.left != null && isLeafNode(root.left)) {
            ans = root.left.val;
        }

        return ans + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        new Solution_404().sumOfLeftLeaves(new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, 15, 7)));
    }
}
