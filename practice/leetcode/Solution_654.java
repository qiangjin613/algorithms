package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        // 寻找当前数组中最大的数
        int max = Integer.MIN_VALUE, index = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, start, index);
        root.right = constructMaximumBinaryTree(nums, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution_654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println();
    }
}
