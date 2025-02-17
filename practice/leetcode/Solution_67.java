package leetcode;

/**
 * <a href="https://leetcode.cn/problems/add-binary/description/">67. 二进制求和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_67 {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        // 进位标志
        int flag = 0;
        for (int indexA = a.length() - 1, indexB = b.length() - 1; indexA >= 0 || indexB >= 0 || flag != 0; indexA--, indexB--) {
            int curA = 0, curB = 0;
            if (indexA >= 0) {
                curA = a.charAt(indexA) - '0';
            }
            if (indexB >= 0) {
                curB = b.charAt(indexB) - '0';
            }

            int temp = curA + curB + flag;

            result.append(temp % 2);
            flag = temp / 2;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_67().addBinary("0", "0"));
    }
}
