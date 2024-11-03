package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/">1379. 找出克隆二叉树中的相同节点</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode targetCopy = getTargetCopy(original.left, cloned.left, target);
        if (targetCopy != null) {
            return targetCopy;
        }
        return getTargetCopy(original.left, cloned.right, target);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        System.out.println(new Solution_1379().getTargetCopy(
                new TreeNode(7,
                        treeNode,
                        new TreeNode(3, 6, 19)),
                new TreeNode(7,
                        new TreeNode(4),
                        new TreeNode(3, 6, 19)),
                treeNode
        ));
    }
}
