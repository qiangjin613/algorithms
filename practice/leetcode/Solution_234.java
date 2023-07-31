package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/palindrome-linked-list/">234. 回文链表</a>
 */
public class Solution_234 {
    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 3, 2, 1);
        System.out.println(new Solution_234().isPalindrome(head));
    }

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean result = traverse(head.next);
        result = result && (head.val == left.val);
        left = left.next;
        return result;
    }
}
