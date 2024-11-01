package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">700. 二叉搜索树中的搜索</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_700().searchBST(new TreeNode(
                4,
                new TreeNode(2, 1, 3),
                new TreeNode(7)
        ), 2));
    }
}
