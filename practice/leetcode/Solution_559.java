package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/">559. N 叉树的最大深度</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_559 {

    /**
     * 深度优先搜索
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int max = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            max = Math.max(childDepth, max);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> children3 = new ArrayList<>();
        children3.add(node5);
        children3.add(node6);
        Node node3 = new Node(3, children3);

        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(node3);
        children.add(node2);
        children.add(node4);
        System.out.println(new Solution_559().maxDepth(new Node(1, children)));
    }

    // Definition for a Node.
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
    };
}
