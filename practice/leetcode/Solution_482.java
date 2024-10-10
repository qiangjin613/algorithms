package leetcode;

/**
 * <a href="https://leetcode.cn/problems/license-key-formatting/">482. 密钥格式化</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_482 {

    /**
     * 方法一：模拟，从后往前处理，避免对首个分区的分情况讨论和取余操作。
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder("");
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            res.append(Character.toUpperCase(s.charAt(i)));
            cnt ++;
            if (cnt % k == 0) {
                res.append('-');
            }
        }
        if (res.length() > 0 && res.charAt(res.length() - 1) == '-') {
            res.deleteCharAt(res.length() - 1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_482().licenseKeyFormatting("5-F3Z-2e-9-w", 4));
    }
}
