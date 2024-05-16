package leetcode;

/**
 * <a href="https://leetcode.cn/problems/sqrtx/description/">69. x 的平方根</a>
 */
public class Solution_69 {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_69().mySqrt(1));
    }
}
