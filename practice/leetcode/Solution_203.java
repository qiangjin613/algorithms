package leetcode;

import leetcode.structure.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">203. 移除链表元素</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_203 {

    public ListNode removeElements(ListNode head, int val) {
        // 技巧：对于头节点 == null 和 会删除头节点的情况，这里创建哑节点简化删除逻辑
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null) {
            if (p.next.val != val) {
                p = p.next;
                continue;
            }
            p.next = p.next.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        new Solution_203().removeElements(ListNode.build(1, 2, 6, 3, 4, 5, 6), 6).print();
    }
}
