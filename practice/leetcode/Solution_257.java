package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-paths/description/">257. 二叉树的所有路径</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> paths = new ArrayList<>();
        traverse(root, "", paths);
        return paths;
    }

    private void traverse(TreeNode root, String tempPath, List<String> paths) {
        if (root == null) {
            return;
        }
        tempPath += root.val;
        // 如果是页节点
        if (root.left == null && root.right == null) {
            paths.add(tempPath);
        }
        tempPath += "->";
        traverse(root.left, tempPath, paths);
        traverse(root.right, tempPath, paths);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_257().binaryTreePaths(new TreeNode(
                1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3)
        )));
    }
}
