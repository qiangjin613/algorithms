package leetcode;

/**
 * <a href="https://leetcode.cn/problems/1-bit-and-2-bit-characters/">717. 1 比特与 2 比特字符</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_717 {

    public boolean isOneBitCharacter(int[] bits) {
        boolean ans = true;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                ans = true;
            } else {
                i ++;
                ans = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_717().isOneBitCharacter(new int[] {1, 0, 0}));
        System.out.println(new Solution_717().isOneBitCharacter(new int[] {1, 1, 1, 0}));
    }
}
