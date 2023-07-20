package leetcode.structure;

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

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
