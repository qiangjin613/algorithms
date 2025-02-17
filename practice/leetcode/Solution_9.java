package leetcode;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/description/">9. 回文数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_9 {

    /**
     * 转为字符串再处理
     */
    public boolean isPalindrome(int x) {
        char[] nums = (x + "").toCharArray();
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (nums[i] != nums[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 翻转整数，再判等
     */
    public boolean isPalindrome_2(int x) {
        if (x < 0) {
            return false;
        }

        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return x == cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_9().isPalindrome(121));
    }
}
