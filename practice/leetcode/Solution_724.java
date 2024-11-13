package leetcode;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/">724. 寻找数组的中心下标</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_724 {

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        // muns 的前缀和数组
        int[] flag = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                flag[i] = nums[i];
            } else {
                flag[i] = flag[i - 1] + nums[i];
            }
        }

        // 查找中心下标
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (flag[len - 1] - flag[i] == 0) {
                    return i;
                }
            } else if (flag[i - 1] == flag[len - 1] - flag[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_724().pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(new Solution_724().pivotIndex(new int[] {1, 2, 3}));
    }
}
