package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. 从前序与中序遍历序列构造二叉树</a>
 */
public class Solution_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        // 确定当前树头节点在中序遍历中的位置
        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }

        int leftTreeSize = inIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart + 1, inIndex);
        root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, inIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution_105().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println();
    }
}
