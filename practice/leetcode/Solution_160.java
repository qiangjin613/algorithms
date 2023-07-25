package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/intersection-of-two-linked-lists/">160. 相交链表</a>
 */
public class Solution_160 {
    public static void main(String[] args) {
        ListNode headA = ListNode.build(1, 2, 3);
        ListNode headB = ListNode.build(5, 6);
        headB.next.next.next = headA.next.next;
        ListNode intersectionNode = new Solution_160().getIntersectionNode(headA, headB);
        intersectionNode.print();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null)
                p2 = headA;
            else
                p2 = p2.next;
        }
        return p1;
    }
}
