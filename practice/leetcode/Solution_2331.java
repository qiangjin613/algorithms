package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/evaluate-boolean-binary-tree/">2331. 计算布尔二叉树的值</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_2331 {

    /**
     * 后序遍历
     */
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        boolean ans;
        if (root.val == 2) {
            ans = left || right;
        } else {
            ans = left && right;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2331().evaluateTree(new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3, 0, 1))));
    }
}
