package leetcode.lcr;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/">LCR 145. 判断对称二叉树</a>
 *
 * @see leetcode.Solution_101 101. 对称二叉树
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_145 {

    /**
     * 使用同步遍历的方法解决（二叉树 + 双指针）
     */
    public boolean checkSymmetricTree(TreeNode root) {
        return check(root.left, root.right);
    }

    /**
     * 二叉树中的双指针遍历
     */
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 迭代遍历，镜像判断可理解为两个一组进行判断
     */
    public boolean checkSymmetricTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }



    public static void main(String[] args) {
        new Solution_LCR_145().checkSymmetricTree(new TreeNode(
                5,
                new TreeNode(7, 8, 3),
                new TreeNode(9, 2, 4)
        ));
    }
}
