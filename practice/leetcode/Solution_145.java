package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">145. 二叉树的后序遍历</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraverse(root, res);
        return res;
    }

    private void postorderTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postorderTraverse(root.left, res);
        postorderTraverse(root.right, res);

        res.add(root.val);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_145().postorderTraversal(new TreeNode(
                1,
                null,
                new TreeNode(2, new TreeNode(3), null))));
    }
}
