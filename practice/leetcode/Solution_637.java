package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">637. 二叉树的层平均值</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_637 {

    /**
     * 如何区分是第几层的？ -> 使用<b>层次遍历</b>
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curNodeNum = queue.size();
            double curSum = 0;
            for (int i = 0; i < curNodeNum; i++) {
                TreeNode node = queue.poll();

                // do sth.
                curSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(curSum / curNodeNum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_637().averageOfLevels(new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, 15, 7)
        )));
    }
}
