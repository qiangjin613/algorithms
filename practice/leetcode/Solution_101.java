package leetcode;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/description/">101. 对称二叉树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    /**
     * 递归
     */
    public boolean check(TreeNode lTree, TreeNode rTree) {
        if (lTree == null ^ rTree == null) {
            return false;
        }
        if (lTree == null) {
            return true;
        }
        // 比较值，然后从树两边向轴汇拢
        return lTree.val == rTree.val && check(lTree.left, rTree.right) && check(lTree.right, rTree.left);
    }

    /**
     * 递归
     */
    public boolean isSymmetric_2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode lTree = queue.poll();
            TreeNode rTree = queue.poll();

            if (lTree == null ^ rTree == null) {
                return false;
            }
            // 如果 左右两个节点都为 null 时，跳过本次循环
            if (lTree == null) {
                continue;
            }

            // 当两个节点值不相等时，就已经不对称了，直接返回 false
            if (lTree.val != rTree.val) {
                return false;
            }

            // 将子树添加到队列中，继续判断
            queue.offer(lTree.left);
            queue.offer(rTree.right);

            queue.offer(lTree.right);
            queue.offer(rTree.left);
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(new Solution_101().isSymmetric(new TreeNode(
                1,
                new TreeNode(2, 3, 4),
                new TreeNode(2, 4, 3))));
        System.out.println(new Solution_101().isSymmetric_2(new TreeNode(
                1,
                new TreeNode(2, 3, 4),
                new TreeNode(2, 4, 3))));
    }
}
