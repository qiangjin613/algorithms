package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
 */
public class Solution_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        new Solution_83().deleteDuplicates(ListNode.build(1,2,3,3)).print();
    }
}
