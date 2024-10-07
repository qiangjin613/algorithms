package leetcode;

/**
 * <a href="https://leetcode.cn/problems/add-strings/description/">415. 字符串相加</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int temp = 0;
        while (index1 >= 0 || index2 >= 0 || temp != 0) {
            if (index1 >= 0) {
                temp += num1.charAt(index1) - '0';
                index1 --;
            }
            if (index2 >= 0) {
                temp += num2.charAt(index2) - '0';
                index2 --;
            }
            sum.append(temp % 10);
            temp /= 10;
        }
        return sum.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_415().addStrings("0", "0"));
        System.out.println(new Solution_415().addStrings("1", "9"));
        System.out.println(new Solution_415().addStrings("3", "2134"));
    }
}
