package leetcode;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/">58. 最后一个单词的长度</a>
 */
public class Solution_58 {

    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean flag = false;
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == ' ' && flag) {
                break;
            }
            if (s.charAt(index) == ' ') {
                continue;
            }
            result++;
            flag = true;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_58().lengthOfLastWord("fhg  aa       "));
    }
}
