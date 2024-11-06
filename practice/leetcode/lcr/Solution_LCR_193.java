package leetcode.lcr;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/">LCR 193. 二叉搜索树的最近公共祖先</a>
 *
 * @see leetcode.Solution_235
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_193 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ans = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            // 会多次更新结果，直到经过一个“岔路”
            if (pathP.get(i) == pathQ.get(i)) {
                ans = pathP.get(i);
            }
        }
        return ans;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        path.add(node);
        while (node != target) {
            if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
            path.add(node);
        }
        return path;
    }

    /**
     * 在 p、q 没 “分叉” 前都有统一的路径
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            if (ans.val > p.val && ans.val > q.val) {
                ans = ans.left;
            } else if (ans.val < p.val && ans.val < q.val) {
                ans = ans.right;
            }
            // 当没有统一的大小节点时，就说明 p、q 在岔路口了
            else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2,
                new TreeNode(0),
                new TreeNode(4, 3, 5));
        TreeNode q = new TreeNode(8, 7, 9);
        System.out.println(new Solution_LCR_193().lowestCommonAncestor(new TreeNode(6, p, q), p, q));
    }
}
