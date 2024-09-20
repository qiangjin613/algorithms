package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        // 将 root 的左子树当作右子树
        root.right = root.left;

        // 将原来的右子树连接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = temp;

        root.left = null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        new Solution_114().flatten(root);
        System.out.println();
    }
}
