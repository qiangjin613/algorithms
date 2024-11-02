package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/leaf-similar-trees/">872. 叶子相似的树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        traverse(root1, nums1);
        traverse(root2, nums2);
        return nums1.toString().equals(nums2.toString());
    }

    private void traverse(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
        traverse(root.left, ans);
        traverse(root.right, ans);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_872().leafSimilar(
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(2, 7, 4)),
                        new TreeNode(1, 9, 8)),
                new TreeNode(3,
                        new TreeNode(5, 6, 7),
                        new TreeNode(1,
                                new TreeNode(4),
                                new TreeNode(2, 9, 8)))));
    }
}
