package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/reverse-linked-list/">206. 反转链表</a>
 */
public class Solution_206 {
    public static void main(String[] args) {
        new Solution_206().reverseList(ListNode.build(1, 2)).print();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
