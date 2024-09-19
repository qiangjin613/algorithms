package leetcode.structure;

import java.util.Objects;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public static ListNode build(int... vals) {
        ListNode list = new ListNode(vals[0]), p = list;
        for (int i = 1; i < vals.length; i++) {
            p.next = new ListNode(vals[i]);
            p = p.next;
        }
        return list;
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        // 前序遍历
        System.out.println("前序遍历" + head.val);
        print(head.next);
        // 后序遍历
        System.out.println("后序遍历" + head.val);
    }

    /**
     * 反转前 n 个节点
     */
    // 第 n + 1 个节点
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (head.next == null || n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转链表（迭代）
     */
    public ListNode reverse(ListNode head) {
        ListNode pre, next, cur;
        pre = null;
        next = cur = head;
        while (cur != null) {
            // 以下顺序不可调换
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转链表 a，到 b 截止
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, nxt = a, cur = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        a.next = b;
        return pre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next) && Objects.equals(successor, listNode.successor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, successor);
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5, 6);
        new ListNode().reverseN(head, 8).print();

        ListNode build = ListNode.build(1, 2, 3, 4, 5, 6);
        new ListNode().reverse(build).print();

        new ListNode().print(build(1, 2, 3, 4, 5, 6));
    }
}
