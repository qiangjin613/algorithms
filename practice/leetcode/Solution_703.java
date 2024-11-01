package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-a-stream/">703. 数据流中的第 K 大元素</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_703 {

    static class KthLargest {

        private final Queue<Integer> priorityQueue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            // 对 nums 入栈
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            priorityQueue.offer(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}
