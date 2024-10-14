package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/">501. 二叉搜索树中的众数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_501 {

    private Map<Integer, Integer> map = new HashMap<>();
    private int maxNum = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }
        traverse(root);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != maxNum) {
                continue;
            }
            res.add(entry.getKey());
        }
        int[] res2 = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            res2[i ++] = re;
        }
        return res2;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Integer cnt = map.get(root.val);
        int cutNum = 1;
        if (cnt != null) {
            cutNum = cnt + 1;
        }
        map.put(root.val, cutNum);
        if (maxNum < cutNum) {
            maxNum = cutNum;
        }
        traverse(root.left);
        traverse(root.right);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_501().findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null)))));
        System.out.println(Arrays.toString(new Solution_501().findMode(new TreeNode(
                2,
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                new TreeNode(1,
                                        null,
                                        new TreeNode(2)),
                                null)),
                null
        ))));
    }
}
