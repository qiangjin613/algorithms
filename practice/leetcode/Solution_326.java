package leetcode;

/**
 * <a href="https://leetcode.cn/problems/power-of-three/">326. 3 的幂</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_326 {

    /**
     * 乘法需要处理溢出
     */
    public boolean isPowerOfThree(int n) {
        int temp = 1;
        // temp > 0，避免溢出
        while (temp < n && temp > 0) {
            temp *= 3;
        }
        return temp == n;
    }

    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 取巧：32 位有符号整数的范围内，最大的 3 的幂为 3^19 = 1162261467。
     * 我们只需要判断 n 是否是 3^19 的约数即可。
     */
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_326().isPowerOfThree2(2147483647));
        System.out.println(new Solution_326().isPowerOfThree2(1));
        System.out.println(new Solution_326().isPowerOfThree2(27));
    }
}
