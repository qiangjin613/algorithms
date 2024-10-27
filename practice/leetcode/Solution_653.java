package leetcode;

import leetcode.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/">653. 两数之和 IV - 输入二叉搜索树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_653 {

    Set<Integer> used = new HashSet<>();
    boolean ans = false;

    public boolean findTarget(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null || ans) {
            return;
        }
        if (used.contains(k - root.val)) {
            ans = true;
            return;
        }
        used.add(root.val);
        traverse(root.left, k);
        traverse(root.right, k);
    }

    /**
     * findTarget 在代码上的优化（逻辑不变）
     */
    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (used.contains(k - root.val)) {
            return true;
        }
        used.add(root.val);
        return findTarget2(root.left, k) || findTarget2(root.right, k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_653().findTarget(new TreeNode(
                5,
                new TreeNode(3, 2, 4),
                new TreeNode(6, null, new TreeNode(7))
        ), 9));
    }
}
