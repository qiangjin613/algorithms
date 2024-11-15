package leetcode;

/**
 * <a href="https://leetcode.cn/problems/find-smallest-letter-greater-than-target/">744. 寻找比目标字母大的最小字母</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_744 {

    /**
     * 二分搜索
     */
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        // 这种改款的二分搜索，需要确保答案一定在搜索数据中
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                // 当 letters[mid] > target 时，letters[mid] 可能还是在搜索范围之内的，所以不用 right = mid - 1，而是 right = mid
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return letters[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_744().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(new Solution_744().nextGreatestLetter(new char[]{'c', 'c', 'c', 'c', 'f', 'j'}, 'c'));
    }
}
