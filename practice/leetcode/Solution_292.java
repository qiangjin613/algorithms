package leetcode;

/**
 * <a href="https://leetcode.cn/problems/nim-game/description/">292. Nim 游戏</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_292 {

    /**
     * 推导 -> 博弈
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_292().canWinNim(1));
    }
}
