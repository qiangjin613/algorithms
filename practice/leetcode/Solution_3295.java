package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/report-spam-message/description/">3295. 举报垃圾信息</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_3295 {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>(Arrays.asList(bannedWords));
        int count = 0;
        for (String msg : message) {
            if (set.contains(msg)) {
                count ++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3295().reportSpam(
                new String[]{"hello","programming","fun"},
                new String[] {"world","programming","leetcode"}));
        System.out.println(new Solution_3295().reportSpam(
                new String[]{"l","i","l","i","l"},
                new String[] {"d","a","i","v","a"}));
    }
}
