package leetcode;

/**
 * <a href="https://leetcode.cn/problems/number-complement/description/">476. 数字的补数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_476 {

    public int findComplement(int num) {
        int res = 0;
        int i = 1;
        while (num != 0) {
            res += i * ((num & 1) ^ 1);
            num >>= 1;
            i <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_476().findComplement(5));
        System.out.println(new Solution_476().findComplement(1));
        System.out.println(new Solution_476().findComplement(2));
    }
}
