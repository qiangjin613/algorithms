package leetcode.structure;

import java.util.Arrays;

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
}
