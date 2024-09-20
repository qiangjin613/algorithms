package leetcode;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/">191. 位1的个数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_191 {

    public int hammingWeight(int n) {
        int count = 0;
        int temp = 1;
        for (int i = 0; i < 32 && temp <= n; i++) {
            if ((n & temp) != 0) {
                count ++;
            }
            temp <<= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_191().hammingWeight(128));
    }
}
