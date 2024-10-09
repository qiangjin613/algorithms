package leetcode;

/**
 * <a href="https://leetcode.cn/problems/hamming-distance/">461. 汉明距离</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_461 {

    /**
     * 方法一：使用内置函数实现位计数
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 方法二：移位实现位计数
     */
    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
            res += z & 1;
            z >>= 1;
        }
        return res;
    }

    /**
     * 方法三：Brian Kernighan 算法
     */
    public int hammingDistance3(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
            z &= z - 1;
            res ++;
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(new Solution_461().hammingDistance(1, 4));
    }
}
