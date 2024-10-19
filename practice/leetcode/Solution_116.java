package leetcode;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        traverse(root.left, root.right);
        return root;
    }

    /**
     * 可以理解为遍历 “三叉树”
     */
    void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        // 将传入的两个节点连接起来
        node1.next = node2;

        // 遍历子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);

        traverse(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;


        Node connect = new Solution_116().connect(root1);
        System.out.println();
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
