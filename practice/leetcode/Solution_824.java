package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/goat-latin">824. 山羊拉丁文</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_824 {

    /**
     * 模拟
     */
    public String toGoatLatin(String sentence) {
        Set<Character> yuanyin = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder goatSentence = new StringBuilder();
        boolean first = true;
        String temp = "";
        Character tempC = null;
        StringBuilder houzhui = new StringBuilder("a");
        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                if (first) {
                    if (yuanyin.contains(c) || yuanyin.contains(Character.toLowerCase(c))) {
                        goatSentence.append(c);
                    } else {
                        tempC = c;
                    }
                } else {
                    goatSentence.append(c);
                }
                temp = "ma";
                first = false;
            } else {
                if (tempC != null) {
                    goatSentence.append(tempC);
                    tempC = null;
                }
                goatSentence.append(temp)
                        .append(houzhui)
                        .append(c);
                houzhui.append("a");
                first = true;
            }
        }

        if (tempC != null) {
            goatSentence.append(tempC);
        }
        goatSentence.append(temp).append(houzhui);

        return goatSentence.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_824().toGoatLatin("I speak Goat Latin pLatin"));
    }
}
