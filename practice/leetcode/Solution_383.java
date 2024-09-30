package leetcode;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/description/">383. 赎金信</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] flag = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            flag[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int temp = ransomNote.charAt(i) - 'a';
            if (flag[temp] > 0) {
                flag[temp] --;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_383().canConstruct("aa", "aab"));
    }
}
