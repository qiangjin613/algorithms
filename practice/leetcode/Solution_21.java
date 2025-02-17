package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_21 {

    /**
     * 使用 list1、list2 充当遍历两个链表的双指针
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 表头节点
        ListNode dummy = new ListNode(), p = dummy;

        // 合并链表
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2), p1 = list1;
        ListNode list2 = new ListNode(3), p2 = list2;
        // 造数
        for (int i = 5; i < 20; i++) {
            if (Math.random() > 0.6) {
                p1.next = new ListNode(i);
                p1 = p1.next;
            } else {
                p2.next = new ListNode(i);
                p2 = p2.next;
            }
        }

        ListNode listNode = new Solution_21().mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
