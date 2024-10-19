package leetcode;

import java.util.*;

/**
 * <a href = "https://leetcode.cn/problems/random-pick-with-blacklist/">710. 黑名单中的随机数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_710 {

    /**
     * 缺点：内存占用过高
     */
    class Solution {

        int[] datas;

        int len;

        Random random = new Random();

        public Solution(int n, int[] blacklist) {
            Set<Integer> blacks = new LinkedHashSet<>();
            for (int i = 0; i < blacklist.length; i++) {
                blacks.add(blacklist[i]);
            }
            datas = new int[n - blacklist.length];
            for (int i = 0; i < n; i++) {
                if (blacks.contains(i)) {
                    continue;
                }
                datas[len ++] = i;
            }
        }

        public int pick() {
            return datas[random.nextInt(len)];
        }
    }

    /**
     * 因为数据是连续的，所以只需将数据分成两部分，[0, n - blacklist.length) 和 [n - blacklist.length, n) 用来区分有效数据和无效区域。
     * 对于有效区域的黑名单数据，使用一个 map 保存 “有效区域中黑名单 -> 无效区域中白名单” 的映射关系即可。
     * 这样空间复杂度就降低到了只需要占用 “有效区域中黑名单数据” 的大小。
     */
    class Solution2 {
        // 最终数组中的元素个数
        int effectiveLen;
        // mapping 用于记录哪些黑名单索引需要被替换成白名单索引
        HashMap<Integer, Integer> mapping = new HashMap<>();
        Random random = new Random();

        /**
         * 构造函数，时间复杂度 O(n)
         *
         * @param n 最终数组中的元素个数
         * @param blacklist 黑名单中的元素索引集合
         */
        public Solution2(int n, int[] blacklist) {
            effectiveLen = n - blacklist.length;
            Set<Integer> blacks = new HashSet<>();
            for (int i = 0; i < blacklist.length; i++) {
                blacks.add(blacklist[i]);
            }
            int rightIndex = n - 1;
            // 遍历黑名单中
            for (int i = 0; i < blacklist.length; i++) {
                // 已经再黑名单区域的数据不进行映射
                if (blacklist[i] >= effectiveLen) {
                    continue;
                }
                if (blacks.contains(blacklist[i])) {
                    while (blacks.contains(rightIndex)) {
                        rightIndex --;
                    }
                    mapping.put(blacklist[i], rightIndex --);
                }
            }
        }

        /**
         * 获取随机数，时间复杂度 O(logn)
         *
         * @return 随机数
         */
        public int pick() {
            int index = random.nextInt(effectiveLen);
            if (mapping.containsKey(index)) {
                return mapping.get(index);
            }
            return index;
        }
    }


    public static void main(String[] args) {
         Solution2 obj = new Solution_710().new Solution2(4, new int[] {2, 1});
         int param_1 = obj.pick();
    }
}
