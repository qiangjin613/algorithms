package leetcode.lcr;

import leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/">LCR 194. 二叉树的最近公共祖先</a>
 *
 * @see leetcode.Solution_236
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_194 {

    private HashMap<Integer, TreeNode> parentMap = new HashMap<>();

    /**
     * 求二叉树的公共祖先，就要分开遍历获取路径了（因为他不像 BST 中有大小规律）
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root);

        Set<Integer> visited  = new HashSet<>();
        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }

        return null;
    }

    /**
     * 遍历并存储父节点
     */
    private void traverse(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            traverse(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            traverse(root.right);
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solutions/217281/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/">Krahets 题解</a>
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        // root 的左 / 右子树中都不包含 p , q
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // left != null and right != null
        // 说明 p , q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root
        return root;
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        p1.right = q1;
        System.out.println(new Solution_LCR_194().lowestCommonAncestor2(p1,p1,q1));


        TreeNode q = new TreeNode(4);

        TreeNode p = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2, new TreeNode(7), q));

        System.out.println(new Solution_LCR_194().lowestCommonAncestor2(new TreeNode(
                3,
                        p,
                        new TreeNode(1, 0, 8)),
                p, new TreeNode(4)));
    }
}
