package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/unique-morse-code-words">804. 唯一摩尔斯密码词</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_804 {

    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 1) {
            return 1;
        }

        String[] dict = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-", "-.--","--.."};

        Set<String> flag = new HashSet<>();
        Set<String> pwd = new HashSet<>();
        for (String word : words) {
            if (!flag.add(word)) {
                continue;
            }
            StringBuilder temp = new StringBuilder();
            for (char c : word.toCharArray()) {
                temp.append(dict[c - 'a']);
            }
            pwd.add(temp.toString());
        }

        return pwd.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_804().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
