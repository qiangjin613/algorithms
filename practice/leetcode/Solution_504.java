package leetcode;

/**
 * <a href="https://leetcode.cn/problems/base-7/">504. 七进制数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_504 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            num *= -1;
            flag = true;
        }
        while (num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        if (flag) {
            res.append("-");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_504().convertToBase7(100));
        System.out.println(new Solution_504().convertToBase7(-7));
    }
}
