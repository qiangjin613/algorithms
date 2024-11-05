package leetcode.lcr;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/">LCR 150. 彩灯装饰记录 II</a>
 *
 * @see leetcode.Solution_102 102. 二叉树的层序遍历
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_150 {

    /**
     * 层次遍历
     */
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevelAns = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                curLevelAns.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!curLevelAns.isEmpty()) {
                ans.add(curLevelAns);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_LCR_150().decorateRecord(new TreeNode(
                5,
                new TreeNode(7, 8, 3),
                new TreeNode(9, 2, 4)
        )));
    }
}
