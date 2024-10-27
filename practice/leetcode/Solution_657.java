package leetcode;

/**
 * <a href="https://leetcode.cn/problems/robot-return-to-origin/">657. 机器人能否返回原点</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_657 {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                default:
                case 'U': y++; break;
                case 'D': y--; break;
                case 'R': x++; break;
                case 'L': x--; break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_657().judgeCircle("UD"));
        System.out.println(new Solution_657().judgeCircle("UDD"));
        System.out.println(new Solution_657().judgeCircle("LL"));
    }
}
