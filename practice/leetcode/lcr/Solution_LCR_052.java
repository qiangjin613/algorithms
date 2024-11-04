package leetcode.lcr;

import leetcode.Solution_897;
import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/NYBBNL/">LCR 052. 递增顺序搜索树</a>
 *
 * @see Solution_897 897. 递增顺序搜索树
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_052 {

    TreeNode lastNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        lastNode = dummy;
        traverse(root);
        return dummy.right;
    }

    /**
     * Node: 上一个节点不能在方法中进行传递，比如这样：traverse(TreeNode node, TreeNode lastNode)，导致不是真正的 “上一个” 节点
     * @param node
     */
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);

        System.out.println(lastNode.val);

        lastNode.right = node;
        node.left = null;
        lastNode = node;

        traverse(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_LCR_052().increasingBST(
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
