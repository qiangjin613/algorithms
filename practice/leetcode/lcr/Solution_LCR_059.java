package leetcode.lcr;

import leetcode.Solution_703;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/jBjn9C/">LCR 059. 数据流中的第 K 大元素</a>
 *
 * @see Solution_703 703. 数据流中的第 K 大元素
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_LCR_059 {

    /**
     * 使用堆解决
     */
    static class KthLargest {

        private final Queue<Integer> priorityQueue = new PriorityQueue<>();
        private final int maxSize;

        public KthLargest(int k, int[] nums) {
            maxSize = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size() > maxSize) {
                priorityQueue.remove();
            }
            return priorityQueue.element();
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
    }
}
