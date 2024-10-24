package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/">617. 合并二叉树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_617 {

    /**
     * 深度优先搜索
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_617().mergeTrees(
                new TreeNode(1,
                        new TreeNode(3, new TreeNode(5), null),
                        new TreeNode(2)),
                new TreeNode(2,
                        new TreeNode(1, null, new TreeNode(4)),
                        new TreeNode(3, null, new TreeNode(7)))
        ));
    }
}
