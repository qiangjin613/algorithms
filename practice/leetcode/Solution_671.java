package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/">671. 二叉树中第二小的节点</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_671 {

    int rootVal, ans = -1;

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        traverse(root);
        return ans;
    }

    /**
     * 找 大于 min 的最小值
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (ans != -1 && root.val >= ans) {
            return;
        }

        // 更新结果
        if (root.val > rootVal) {
            ans = root.val;
        }

        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_671().findSecondMinimumValue(new TreeNode(
                2,
                new TreeNode(2),
                new TreeNode(5, 5, 7)
        )));
    }
}
