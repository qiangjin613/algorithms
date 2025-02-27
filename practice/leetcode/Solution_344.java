package leetcode;

/**
 * <a href = "https://leetcode.cn/problems/reverse-string/description/">344. 反转字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        char[] chars = "hello".toCharArray();
        new Solution_344().reverseString(chars);
        System.out.println(chars);
    }
}
