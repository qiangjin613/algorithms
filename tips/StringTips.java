import leetcode.Solution_819;
import leetcode.Solution_821;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串处理中常用技巧
 * <p>
 *  1. 分割字符串；
 *
 * @see Solution_819 819. 最常见的单词
 * @see Solution_821 821. 字符的最短距离
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class StringTips {

    /**
     * 从字符串中寻找出单词
     */
    public static List<String> splitString(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder tempWord = new StringBuilder();
        int length = str.length();
        for (int i = 0; i <= length; i++) {
            if (i < str.length() && Character.isLetter(str.charAt(i))) {
                tempWord.append(str.charAt(i));
            } else if (tempWord.length() > 0) {
                ans.add(tempWord.toString());
                tempWord.setLength(0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(splitString("Bob hit a ball, the hit BALL flew far after it was hit."));
    }
}
