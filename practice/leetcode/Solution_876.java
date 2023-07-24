package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/middle-of-the-linked-list/">876. 链表的中间结点</a>
 */
public class Solution_876 {

    public static void main(String[] args) {
        new Solution_876().middleNode(ListNode.build(1,2,3,4,5)).print();
    }

    /**
     * 如果链表的节点个数是偶数，则返回的就是靠后的那个节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }
}
