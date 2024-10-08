package leetcode;

/**
 * <a href="https://leetcode.cn/problems/number-of-segments-in-a-string/">434. 字符串中的单词数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_434 {

    /**
     * 方法一：遍历，使用标记 + 对原始子字符进行处理
     */
    public int countSegments(String s) {
        int count = 0;
        boolean flag = false;
        s += " ";
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                flag = true;
            }
            if (c == ' ' && flag) {
                count++;
                flag = false;
            }
        }
        return count;
    }

    /**
     * 方法二：遍历，从单词的第一个下标的特征出发
     */
    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_434().countSegments2("aaa   ad ff sdf "));
        System.out.println(new Solution_434().countSegments2("  "));
        System.out.println(new Solution_434().countSegments2("  f"));
        System.out.println(new Solution_434().countSegments2(" a f"));
    }
}
