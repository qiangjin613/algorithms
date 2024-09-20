package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/linked-list-cycle-ii/">142. 环形链表 II</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_142 {
    public static void main(String[] args) {
        ListNode head = ListNode.build(3, 2, 0, -4);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head.next;
        new Solution_142().detectCycle(head).print();
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
