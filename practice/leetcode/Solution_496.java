package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i/">496. 下一个更大元素 I</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        // 缓存 nums2 索引
        Map<Integer, Integer> num2Key2Index = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            num2Key2Index.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            Integer num2Index = num2Key2Index.get(nums1[i]);
            if (num2Index == null || num2Index >= nums2.length) {
                res[i] = -1;
                continue;
            }
            num2Index ++;
            while (num2Index < nums2.length) {
                if (nums1[i] < nums2[num2Index]) {
                    res[i] = nums2[num2Index];
                    break;
                }
                num2Index ++;
            }
            if (num2Index == nums2.length) {
                res[i] = -1;
            }
        }

        return res;
    }

    /**
     * 方法：单调栈 + Hash 表
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // 直接缓存 nums2 的计算结果
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            // 依次将栈顶小于 num 的数出栈
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            // 保存 当前位置元素对应的 大于数据的值
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new Solution_496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
