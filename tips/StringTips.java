import leetcode.Solution_819;
import leetcode.Solution_821;
import leetcode.Solution_830;

import java.util.ArrayList;
import java.util.Arrays;
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
     * 使用辅助变量寻找、分割单词
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

    /**
     * 另外一种处理思路是 for - while：寻找单词的起始、终止下标
     *
     * @see Solution_830 830. 较大分组的位置
     */
    public static List<List<Integer>> splitString2(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        // 虽说是使用了两层循环，实际看 i 的变动规则，实际上是 O(n)，只循环一次
        for (int i = 0; i < s.length();) {
            char charI = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == charI) {
                j++;
            }
            if (j - i >= 3) {
                ans.add(new ArrayList<>(Arrays.asList(i, j - 1)));
            }
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(splitString("Bob hit a ball, the hit BALL flew far after it was hit."));
    }
}
