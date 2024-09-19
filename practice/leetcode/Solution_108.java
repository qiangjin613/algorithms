package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/">108. 将有序数组转换为二叉搜索树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBSTBy(nums, 0, nums.length - 1);
    }

    private TreeNode buildBSTBy(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }

        // 选择中间偏左的位置作为中间节点
        int mid = (leftIndex + rightIndex) / 2;
        TreeNode curRoot = new TreeNode(nums[mid]);
        // 构造左右子树，因为在上一行，已经使用 nums[mid] 构建了当前节点，所以在子树递归中，就不需要 mid 参与了
        curRoot.left = buildBSTBy(nums, leftIndex, mid - 1);
        curRoot.right = buildBSTBy(nums, mid + 1, rightIndex);
        return curRoot;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution_108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println("end");
    }
}
