package leetcode;

/**
 * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/">693. 交替位二进制数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_693 {

    public boolean hasAlternatingBits(int n) {
        int x = n & 1;
        n >>= 1;
        while (n != 0) {
            int temp = n & 1;
            if (x == temp) {
                return false;
            }
            x = temp;
            n >>= 1;
        }
        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/solutions/1368822/jiao-ti-wei-er-jin-zhi-shu-by-leetcode-s-bmxd/">（leetcode 题解）方法二：位运算</a>
     */
    public boolean hasAlternatingBits2(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_693().hasAlternatingBits(5));
    }
}
