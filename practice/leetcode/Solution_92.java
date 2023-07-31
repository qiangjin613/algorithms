package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
 */
public class Solution_92 {
    public static void main(String[] args) {
        new Solution_92().reverseBetween(ListNode.build(1, 2, 3, 4, 5, 6), 3, 4).print();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return head.reverseN(head, right);
        }
        // Note
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}
