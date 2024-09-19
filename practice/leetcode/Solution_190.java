package leetcode;

/**
 * <a href="https://leetcode.cn/problems/reverse-bits/">190. 颠倒二进制位</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_190 {

    /**
     * 逐位颠倒
     */
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    /**
     * 分治
     */
    public int reverseBits2(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_190().reverseBits(-3));
    }
}
