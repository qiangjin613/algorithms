package leetcode;

import leetcode.structure.ListNode;

import java.util.PriorityQueue;

/**
 * <a href = "https://leetcode.cn/problems/merge-k-sorted-lists/">23. 合并 K 个升序链表</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {ListNode.build(1,4,5), ListNode.build(1,3,4), ListNode.build(2,6)};
        new Solution_23().mergeKLists2(lists).print();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = new ListNode(-1), p = mergedList;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        // 链头入队
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        // 合并多个链表
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            p.next = temp;
            if (temp.next != null) {
                priorityQueue.add(temp.next);
            }
            p = p.next;
        }
        return mergedList.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(), p = dummy;
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pQueue.add(list);
            }
        }
        while (!pQueue.isEmpty()) {
            ListNode temp = pQueue.poll();
            p.next = temp;
            p = p.next;
            if (temp.next != null) {
                pQueue.add(temp.next);
            }
        }

        return dummy.next;
    }
}
