package example.leetcode;

public class Solution_66 {

    /**
     * 对 digits 数组加 1 时，只需要逆序便利数组，对每一个数值 + 1 后对 10 取余，当不为 1 时返回即可。
     * 特殊情况是，如果出现 [9, 9] 这样的情况，新建一个数据。
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // digits 中所有的元素均为 9
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        new Solution_66().plusOne(new int[] {9, 9});
    }
}
