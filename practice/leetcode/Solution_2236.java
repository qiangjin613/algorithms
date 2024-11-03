package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/root-equals-sum-of-children/">2236. 判断根结点是否等于子结点之和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_2236 {

    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2236().checkTree(new TreeNode(7, 3, 4)));
    }
}
