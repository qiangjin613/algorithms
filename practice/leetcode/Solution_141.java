package leetcode;

import leetcode.structure.ListNode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/description/">141. 环形链表</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> usedNode = new LinkedHashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!usedNode.add(p)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        d.next = b;
        System.out.println(new Solution_141().hasCycle(a));
    }
}
