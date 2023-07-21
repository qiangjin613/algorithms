package leetcode;

import leetcode.structure.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href = "https://leetcode.cn/problems/merge-k-sorted-lists/">23. 合并 K 个升序链表</a>
 */
public class Solution_23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {ListNode.build(1,4,5), ListNode.build(1,3,4), ListNode.build(2,6)};
        new Solution_23().mergeKLists(lists).print();
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
}
