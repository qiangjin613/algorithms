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
        new Solution_86().partition2(head, 3).print();
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

    /**
     * 如果不给 head 一个工作指针，对其处理要更繁琐一点（相比于 partition）
     */
    public ListNode partition2(ListNode head, int x) {
        // dummy1 < x < dummy2
        ListNode dummy1 = new ListNode(), dummy2 = new ListNode();
        ListNode p1 = dummy1, p2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
                head = head.next;
                p1.next = null;
            } else {
                p2.next = head;
                p2 = p2.next;
                head = head.next;
                p2.next = null;
            }
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }
}
