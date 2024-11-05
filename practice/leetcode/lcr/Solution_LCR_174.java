package leetcode.lcr;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">LCR 174. 寻找二叉搜索树中的目标节点</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_174 {

    private Integer ans = null;
    private int cnt;
    private int count = 0;
    /**
     * BST + 第几大 -> 中序遍历
     */
    public int findTargetNode(TreeNode root, int cnt) {
        this.cnt = cnt;
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode node) {
        if (node == null || ans != null) {
            return;
        }
        traverse(node.right);

        count++;
        if (count == cnt) {
            ans = node.val;
        }

        traverse(node.left);
    }


    public static void main(String[] args) {
        System.out.println(new Solution_LCR_174().findTargetNode(new TreeNode(
                7,
                new TreeNode(3, 1, 5),
                new TreeNode(9)
        ), 2));
    }
}
