package leetcode;

/**
 * <a href="https://leetcode.cn/problems/power-of-four/">342. 4的幂</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_342 {

    public boolean isPowerOfFour(int n) {
        while (n % 4 == 0 && n > 0) {
            n /= 4;
        }
        return n == 1;
    }

    public boolean isPowerOfFour2(int n) {
        // 4 的幂的二进制只有一个 1 并且 1 的位置出现在奇数位上
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public boolean isPowe2rOfFour3(int n) {
        // 如果 n 是 4 的幂，我们可以发现它除以 3 的余数一定为 1
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_342().isPowerOfFour(0));
        System.out.println(new Solution_342().isPowerOfFour(1));
        System.out.println(new Solution_342().isPowerOfFour(2));
        System.out.println(new Solution_342().isPowerOfFour(3));
        System.out.println(new Solution_342().isPowerOfFour(4));
    }
}
