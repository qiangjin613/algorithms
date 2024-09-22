package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/isomorphic-strings/description/">205. 同构字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_205 {

    /**
     * 转换为另一种规则进行比对
     */
    public boolean isIsomorphic2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

        /**
         * 双向映射关系
         * <p>
         * Note: 最好的解决办法是建立两个 Map 解决，如果是单个 Map 就判断就比较麻烦，且容易出错
         */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> s2t = new HashMap<>(s.length());
        Map<Character, Character> t2s = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char indexS = s.charAt(i);
            char indexT = t.charAt(i);

            if ((s2t.containsKey(indexS) && s2t.get(indexS) != indexT) ||
                    (t2s.containsKey(indexT) && t2s.get(indexT) != indexS)) {
                return false;
            }

            s2t.put(indexS, indexT);
            t2s.put(indexT, indexS);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_205().isIsomorphic("egg", "abb"));
        System.out.println(new Solution_205().isIsomorphic("aaeaa", "uuxyy"));
        System.out.println(new Solution_205().isIsomorphic("foo", "bar"));
        System.out.println(new Solution_205().isIsomorphic("paper", "title"));
        System.out.println(new Solution_205().isIsomorphic("badc", "baba"));
    }
}
