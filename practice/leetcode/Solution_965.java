package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/univalued-binary-tree/">965. 单值二叉树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_965 {

    private int lastVal = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (lastVal != -1 && lastVal != root.val) {
            return false;
        }
        lastVal = root.val;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_965().isUnivalTree(
                new TreeNode(10,
                        new TreeNode(5, 3, 7),
                        new TreeNode(15,
                                null,
                                new TreeNode(18)))));
    }
}
