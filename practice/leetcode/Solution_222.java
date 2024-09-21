package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/description/">222. 完全二叉树的节点个数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_222().countNodes(new TreeNode(
                1,
                new TreeNode(1, 2, 3),
                new TreeNode(1, 4, 4))));
    }
}
