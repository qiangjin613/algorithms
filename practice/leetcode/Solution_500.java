package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/keyboard-row/">500. 键盘行</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_500 {

    public String[] findWords(String[] words) {
        String[] keyboard = new String[] {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < keyboard.length; i++) {
            for (char c : keyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            int flag = -1;
            boolean isTrue = true;
            for (char c : word.toCharArray()) {
                Integer integer = map.get(Character.toLowerCase(c));
                if (flag != -1 && integer != flag) {
                    isTrue = false;
                    break;
                }
                flag = integer;
            }
            if (isTrue) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_500().findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }
}
