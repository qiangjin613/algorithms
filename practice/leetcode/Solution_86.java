package leetcode;

import leetcode.structure.ListNode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/partition-list/">86. 分隔链表</a>
 */
public class Solution_86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1), p = head;
        // 造数
        for (Integer integer : Arrays.asList(4, 3, 2, 5, 2)) {
            p.next = new ListNode(integer);
            p = p.next;
        }
        new Solution_86().partition(head, 3).print();
    }

    /**
     * 将链表拆分为两个链表，最后再合并
     */
    public ListNode partition(ListNode head, int x) {
        // 小于 x 的链表
        ListNode list1 = new ListNode(-1), p1 = list1;
        // 大于 x 的链表
        ListNode list2 = new ListNode(-1), p2 = list2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // Note: 这里要将链表进行断开，否则合并的链表会成环
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = list2.next;
        return list1.next;
    }
}
