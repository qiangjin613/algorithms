package leetcode;

import leetcode.structure.TreeNode;

/**
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 异或判断
        if (p == null ^ q == null) {
            return false;
        }
        // 排除为 Null 的情况
        else if (p == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean sameTree = isSameTree(p.left, q.left);
        if (!sameTree) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_100().isSameTree(
                new TreeNode(1, 2, 3),
                new TreeNode(1, 2, 3)));
    }
}
