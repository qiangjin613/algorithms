package leetcode;

/**
 * <a href="https://leetcode.cn/problems/perfect-number/">507. 完美数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_507 {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int xSum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                xSum += i;
                if (num / i != i) {
                    xSum += num / i;
                }
            }
        }
        return xSum == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_507().checkPerfectNumber(28));
        System.out.println(new Solution_507().checkPerfectNumber(7));
        System.out.println(new Solution_507().checkPerfectNumber(1));
    }
}
