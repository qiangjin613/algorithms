package leetcode;

/**
 * <a href="https://leetcode.cn/problems/arranging-coins/">441. 排列硬币</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_441 {

    public int arrangeCoins(int n) {
        int i = 1;
        while (n - i >= 0) {
            n -= i;
            i ++;
        }
        return -- i;
    }

    public int arrangeCoins2(int n) {
        int i = 0;
        while (n - i > 0) {
            i ++;
            n -= i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_441().arrangeCoins2(1));
        System.out.println(new Solution_441().arrangeCoins2(5));
        System.out.println(new Solution_441().arrangeCoins2(8));
    }
}
