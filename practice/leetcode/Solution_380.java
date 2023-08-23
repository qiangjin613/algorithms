package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <a href = "https://leetcode.cn/problems/insert-delete-getrandom-o1/">380. O(1) 时间插入、删除和获取随机元素</a>
 */
public class Solution_380 {

    class RandomizedSet {

        private int[] values;
        private int valLength;
        private Map<Integer, Integer> valToIndex;

        public RandomizedSet() {
            values = new int[2 * 100_000];
            valLength = 0;
            valToIndex = new HashMap<>(16);
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            valToIndex.put(val, valLength);
            values[valLength ++] = val;
            return true;
        }

        /**
         * Notice: 边界检查（删除最后一个元素、当数据只剩一个时的删除操作）
         */
        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            Integer valIndex = valToIndex.remove(val);
            // Notice: 当删除最后一个元素时，不需要进行移动元素
            if (valIndex != valLength - 1) {
                values[valIndex] = values[valLength - 1];
                valToIndex.put(values[valIndex], valIndex);
            }
            valLength --;
            return true;
        }

        public int getRandom() {
            return values[new Random().nextInt(valLength)];
        }
    }

    public static void main(String[] args) {
        Solution_380 solution_380 = new Solution_380();
        RandomizedSet randomizedSet = solution_380.new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(4));
        System.out.println(randomizedSet.remove(4));
        System.out.println(randomizedSet.insert(-1));
        System.out.println(randomizedSet.remove(0));
    }
}
