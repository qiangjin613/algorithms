package leetcode;

/**
 * <a href="https://leetcode.cn/problems/convert-a-number-to-hexadecimal/">405. 数字转换为十六进制数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_405 {

    /**
     * 分组计算
     * </p>
     * Note: 长度为 32 的二进制本身就是使用补码规则来表示的，因此我们无须额外处理「补码」问题。
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (i * 4)) & 0xF;
            if (res.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                res.append(digit);
            }
        }
        return res.toString();
    }

    /**
     * 模拟、进制转换
     * </p>
     * Note: 要自己处理补码问题，将 num 的原码转换为补码：可先在 num 基础上加上 2^32 的偏移量，再进行进制转换。
     * eg. -1 = (OxFFFFFFFF + 1) - 1
     */
    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        }
        long curNum = num;
        // 处理补码
        if (num < 0) {
            // 这样写会导致数据转换时出现问题！！！
            // curNum += Math.pow(2, 32) + num;
            curNum = (long) (Math.pow(2, 32) + num);
        }
        StringBuilder res = new StringBuilder();
        while (curNum != 0) {
            long u = curNum % 16;
            char c;
            if (u < 10) {
                c = (char) (u + '0');
            } else {
                c = (char) (u - 10 + 'a');
            }
            res.append(c);
            curNum /= 16;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_405().toHex2(-1));
        System.out.println(new Solution_405().toHex(-26));
        System.out.println(new Solution_405().toHex(-1));
    }
}
