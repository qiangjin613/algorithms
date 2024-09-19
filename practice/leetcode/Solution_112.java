package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum/description/">112. 路径总和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int subTarget = targetSum - root.val;
        return hasPathSum(root.left, subTarget) || hasPathSum(root.right, subTarget);
    }
}
