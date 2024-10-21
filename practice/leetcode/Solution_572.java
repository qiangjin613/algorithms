package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href = "https://leetcode.cn/problems/subtree-of-another-tree/">572. 另一棵树的子树</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder str1 = new StringBuilder();
        dfs(root, str1);
        StringBuilder str2 = new StringBuilder();
        dfs(subRoot, str2);
        return str1.indexOf(str2.toString()) != -1;
    }

    /**
     * 一棵子树上的点在深度优先搜索序列（即先序遍历）中是连续的。
     * 但「s 的深度优先搜索序列包含 t 的深度优先搜索序列」是「t 是 s 子树」的必要不充分条件，所以单纯这样做是不正确的。
     * 需要将空值添加进去，来进行区分。
     * <p>
     * 详见：<a href="https://leetcode.cn/problems/subtree-of-another-tree/solutions/233896/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/">(leetcode 题解)方法二：深度优先搜索序列上做串匹配</a>
     */
    private void dfs(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append(" ");
            return;
        }
        str.append('.').append(root.val).append('.');
        dfs(root.left, str);
        dfs(root.right, str);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_572().isSubtree(
                new TreeNode(3,
                        new TreeNode(4, 1, 2),
                        new TreeNode(5)),
                new TreeNode(4,
                        1,
                        2)
        ));
        System.out.println(new Solution_572().isSubtree(
                new TreeNode(12),
                new TreeNode(2)
        ));
    }
}
