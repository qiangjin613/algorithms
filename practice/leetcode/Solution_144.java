package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preTraverse(root, res);
        return res;
    }

    private void preTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);

        preTraverse(root.left, res);
        preTraverse(root.right, res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_144().preorderTraversal(new TreeNode(
                1,
                null,
                new TreeNode(2, new TreeNode(3), null))));
    }
}
