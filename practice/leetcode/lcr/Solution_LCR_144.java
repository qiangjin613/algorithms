package leetcode.lcr;

import leetcode.Solution_226;
import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/">LCR 144. 翻转二叉树</a>
 *
 * @see Solution_226 226. 翻转二叉树
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_144 {

    /**
     * 方法一：后续遍历，获取左右子树返回值
     */
    public TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 其实可以不利用左右子树的返回结果
        TreeNode left = flipTree(root.left);
        TreeNode right = flipTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    /**
     * 方法二：前序遍历也可以完成
     */
    public TreeNode flipTree2(TreeNode root) {
        traverse2(root);
        return root;
    }

    private void traverse2(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;


        traverse2(node.left);
        traverse2(node.right);
    }

    public static void main(String[] args) {
        new Solution_LCR_144().flipTree2(new TreeNode(
                5,
                new TreeNode(7, 8, 3),
                new TreeNode(9, 2, 4)
        ));
    }
}
