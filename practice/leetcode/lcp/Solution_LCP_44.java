package leetcode.lcp;

import leetcode.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/sZ59z6/">LCP 44. 开幕式焰火</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCP_44 {

    private final Set<Integer> flag = new HashSet<>();

    public int numColor(TreeNode root) {
        traverse(root);
        return flag.size();
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        flag.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_LCP_44().numColor(new TreeNode(
                1,
                new TreeNode(3, 2, 1),
                new TreeNode(2)
        )));
    }
}
