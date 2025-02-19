package leetcode;

/**
 * <a href="https://leetcode.cn/problems/divisor-game/">1025. 除数博弈</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_1025 {

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1025().divisorGame(3));
    }
}
