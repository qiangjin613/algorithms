package leetcode;

/**
 * <a href="https://leetcode.cn/problems/add-digits/">258. 各位相加</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_258 {

    public int addDigits(int num) {
        while (num > 9) {
            int temp = 0;
            while (num != 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_258().addDigits(38));
    }
}
