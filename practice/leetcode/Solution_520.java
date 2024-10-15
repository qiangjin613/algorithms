package leetcode;

/**
 * <a href="https://leetcode.cn/problems/detect-capital/">520. 检测大写字母</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_520 {

    /**
     * 将题目条件进行整理
     */
    public boolean detectCapitalUse(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写。
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_520().detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
        System.out.println(new Solution_520().detectCapitalUse("USA"));
        System.out.println(new Solution_520().detectCapitalUse("FlaG"));
        System.out.println(new Solution_520().detectCapitalUse("FlaGa"));
        System.out.println(new Solution_520().detectCapitalUse("alaGa"));
        System.out.println(new Solution_520().detectCapitalUse("alaa"));
    }
}
