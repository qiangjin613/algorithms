package leetcode;

/**
 * <a href="https://leetcode.cn/problems/to-lower-case/">709. 转换成小写字母</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_709 {

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_709().toLowerCase("AdaAddDFSZ"));
    }
}
