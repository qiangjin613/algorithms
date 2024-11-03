package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/">1022. 从根到叶的二进制数之和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_1022 {

    private final List<String> bNums = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        traverse(root, "");
        int ans = 0;
        for (String num : bNums) {
            ans += Integer.parseInt(num, 2);
        }
        return ans;
    }

    private void traverse(TreeNode node, String num) {
        if (node == null) {
            return;
        }
        num += node.val;
        if (node.left == null && node.right == null) {
            bNums.add(num);
        }
        traverse(node.left, num);
        traverse(node.right, num);
    }

    /**
     * <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/solutions/1521470/cong-gen-dao-xie-de-er-jin-zhi-shu-zhi-h-eqss/">直接通过后续遍历获取从根到叶的二进制数之和</a>
     */
    public int sumRootToLeaf2(TreeNode root) {
        return traverse2(root, 0);
    }

    private int traverse2(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        val = (val << 1) | node.val;
        if (node.left == null && node.right == null) {
            return val;
        }

        int left = traverse2(node.left, val);
        int right = traverse2(node.right, val);

        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1022().sumRootToLeaf(
                new TreeNode(1,
                        new TreeNode(0, 0, 1),
                        new TreeNode(1, 0, 1))));
    }
}
