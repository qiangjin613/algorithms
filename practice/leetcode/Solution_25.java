package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/reverse-nodes-in-k-group/">25. K 个一组翻转链表</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_25 {
    public static void main(String[] args) {
        ListNode build = ListNode.build(1, 2, 3, 4, 5);
        new Solution_25().reverseKGroup(build, 3).print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 当链表长度不满足 k 时，不进行翻转
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode reversedHead = a.reverse(a, b);
        a.next = reverseKGroup(b, k);
        return reversedHead;
    }
}
