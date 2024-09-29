package leetcode;

/**
 * <a href="https://leetcode.cn/problems/guess-number-higher-or-lower/">374. 猜数字大小</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_374 extends GuessGame {

    /**
     * 二分
     */
    public int guessNumber(int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int guessRes = guess(mid);
            if (guessRes == 0) {
                return mid;
            } else if (guessRes == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_374().guessNumber(10));
    }
}

class GuessGame {
    int guess(int num) {
        int res = 6 - num;
        if (res == 0) {
            return 0;
        } else if (res > 0) {
            return 1;
        } else {
            return -1;
        }
    };
}