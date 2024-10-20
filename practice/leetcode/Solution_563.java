package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href = "https://leetcode.cn/problems/binary-tree-tilt/">563. 二叉树的坡度</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_563 {

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lSum = dfs(root.left);
        int rSum = dfs(root.right);
        ans += Math.abs(lSum - rSum);
        return lSum + rSum + root.val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_563().findTilt(new TreeNode(
                1,
                2,
                3
        )));
        System.out.println(new Solution_563().findTilt(new TreeNode(
                4,
                new TreeNode(2, 3, 5),
                new TreeNode(9, null, new TreeNode(7))
        )));
    }
}
