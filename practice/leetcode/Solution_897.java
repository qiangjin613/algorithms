package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/increasing-order-search-tree/">897. 递增顺序搜索树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_897 {

    /**
     * 方法一：中序遍历 + 数组
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        TreeNode headNode = new TreeNode();
        TreeNode p = headNode;
        for (Integer val : ans) {
            p.right = new TreeNode(val);
            p = p.right;
        }
        return headNode.right;
    }

    private void traverse(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        traverse(root.left, ans);
        ans.add(root.val);
        traverse(root.right, ans);
    }

    /**
     * <a href="https://leetcode.cn/problems/increasing-order-search-tree/solutions/741961/di-zeng-shun-xu-cha-zhao-shu-by-leetcode-dfrr/">（leetcode 题解）方法二：在中序遍历的过程中改变节点指向</a>
     */
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNode = new TreeNode();
        lastNode = dummyNode;
        traverse2(root);
        return dummyNode.right;
    }

    /** 上一个遍历过的节点 */
    private TreeNode lastNode;

    private void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse2(root.left);

        // 在中序遍历过程中修改节点指向
        lastNode.right = root;
        root.left = null;
        lastNode = root;

        traverse2(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_897().increasingBST(
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        null),
                                new TreeNode(4)),
                        new TreeNode(6,
                                null,
                                new TreeNode(8, 7, 9)))));
    }
}
