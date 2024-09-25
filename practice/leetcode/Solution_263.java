package leetcode;

/**
 * <a href="https://leetcode.cn/problems/ugly-number/description/">263. 丑数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_263 {

    /**
     * 方法1：数学
     * n = 2^a * 3^b * 5^c
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = new int[] {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_263().isUgly(14));
    }
}
