package leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-perfect-square/">367. 有效的完全平方数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_367 {

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (i * i < num && i * i > 0) {
            i ++;
        }
        return i * i == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_367().isPerfectSquare(2147483647));
    }
}
