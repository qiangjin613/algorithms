package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第 N 个结点</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_19 {

    public static void main(String[] args) {
        new Solution_19().removeNthFromEnd(ListNode.build(1, 2, 3, 5), 2).print();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        // h 节点向前走 n 布
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }
        ListNode q = dummy;
        while (p != null) {
            q = q.next;
            p = p.next;
        }
        // 删除 p 节点
        q.next = q.next.next;
        return dummy.next;
    }
}
