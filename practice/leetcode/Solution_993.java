package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree/">993. 二叉树的堂兄弟节点</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_993 {

    private int x;
    private int xLevel;
    private TreeNode xPNode;

    private int y;
    private int yLevel;
    private TreeNode yPNode;


    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        findLevel(root, 0, null);
        return xLevel == yLevel && xPNode != yPNode;
    }

    private void findLevel(TreeNode node, int level, TreeNode pNode) {
        if (node == null) {
            return;
        }
        if (xPNode != null && yPNode != null) {
            return;
        }

        if (node.val == x) {
            xLevel = level;
            xPNode = pNode;
        }
        if (node.val == y) {
            yLevel = level;
            yPNode = pNode;
        }

        findLevel(node.left, level + 1, node);
        findLevel(node.right, level + 1, node);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_993().isCousins(
                new TreeNode(1,
                        new TreeNode(2, null, new TreeNode(4)),
                        new TreeNode(3)),
                2, 3));
    }
}
