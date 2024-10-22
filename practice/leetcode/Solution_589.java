package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/">589. N 叉树的前序遍历</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            dfs(child, ans);
        }
    }

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();
        children.add(new Node(5));
        children.add(new Node(6));
        Node node = new Node(3, children);
        List<Node> children2 = new ArrayList<>();
        children2.add(node);
        children2.add(new Node(2));
        children2.add(new Node(4));
        System.out.println(new Solution_589().preorder(new Node(1, children2)));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
