package leetcode;

/**
 * <a href="https://leetcode.cn/problems/first-bad-version/description/">278. 第一个错误的版本</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_278 extends VersionControl {

    /**
     * 遍历
     */
    public int firstBadVersion(int n) {
        for (int i = 0; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    /**
     * 二分
     */
    public int firstBadVersion2(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                // 答案在区间 [left, mid] 中
                r = mid;
            } else {
                // 答案在区间 [mid+1, right] 中
                l = mid + 1;
            }
        }
        // 当 left == right，区间缩为一个点，即为答案
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_278().firstBadVersion(5));
    }
}


class VersionControl {
    public boolean isBadVersion(int version) {
        return version >= 4;
    }
}
