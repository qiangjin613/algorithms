package example.leetcode;

/**
 * <a href="https://leetcode.cn/problems/missing-number/">268. 丢失的数字</a>
 */
public class Solution_268 {

    /**
     * 打表
     */
    public int missingNumber(int[] nums) {
        boolean[] signs = new boolean[nums.length + 1];
        for (int num : nums) {
            signs[num] = true;
        }
        for (int i = 0; i < signs.length; i++) {
            if (!signs[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 打表（变种）
     */
    public int missingNumber2(int[] nums) {
        // 归位（与快速排序的思想类似）
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
                i--;
            }
        }
        // 查找
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 位运算：亦或
     */
    public int missingNumber3(int[] nums) {
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNum ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            singleNum ^= i;
        }
        return singleNum;
    }

    /**
     * 数学：等差数列求和公式
     */
    public int missingNumber4(int[] nums) {
        int arraySum = (nums.length * (1 + nums.length)) / 2;
        for (int num : nums) {
            arraySum -= num;
        }
        return arraySum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_268().missingNumber2(new int[] {9,8,7,6,5,4,3,2,1}));
    }
}
