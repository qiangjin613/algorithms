package leetcode;

/**
 * <a href="https://leetcode.cn/problems/power-of-two/description/">231. 2 的幂</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_231 {

    /**
     * 超时
     */
    public boolean isPowerOfTwo(int n) {
        int temp = 1;
        while (temp < n) {
            temp *= 2;
            // 溢出
            if (temp == 0) {
                return false;
            }
        }
        return temp == n;
    }

    /**
     * 使用位运算进行优化
     */
    public boolean isPowerOfTwo2(int n) {
        int temp = 1;
        while (temp < n) {
            temp <<= 1;
            // 溢出
            if (temp == 0) {
                return false;
            }
        }
        return temp == n;
    }

    /**
     * 不使用循环
     */
    public boolean isPowerOfTwo3(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_231().isPowerOfTwo(16));
        System.out.println(new Solution_231().isPowerOfTwo(1));
        System.out.println(new Solution_231().isPowerOfTwo(1073741825));
        System.out.println(new Solution_231().isPowerOfTwo2(1073741825));
        System.out.println(new Solution_231().isPowerOfTwo3(1073741825));
    }
}
