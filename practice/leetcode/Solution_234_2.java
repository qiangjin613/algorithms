package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/palindrome-linked-list/">234. 回文链表</a>
 *
 * <p>对 {@link Solution_234} 进行空间优化
 */
public class Solution_234_2 {
    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 3, 2);
        System.out.println(new Solution_234_2().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode reverse = reverse(slow);
        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
}
