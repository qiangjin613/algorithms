package leetcode;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/">13. 罗马数字转整数</a>
 */
public class Solution_13 {

    public int romanToInt(String s) {
        int[] nums = new int[] {1, 5, 10, 50, 100, 500, 1000};

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i != s.length() - 1 && getValue(s.charAt(i + 1)) > getValue(s.charAt(i))) {
                result -= nums[getValue(s.charAt(i))];
            } else {
                result += nums[getValue(s.charAt(i))];
            }
        }

        return result;
    }

    private int getValue(char c) {
        switch (c) {
            default:
            case 'I': return 0;
            case 'V': return 1;
            case 'X': return 2;
            case 'L': return 3;
            case 'C': return 4;
            case 'D': return 5;
            case 'M': return 6;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_13().romanToInt("XLIX"));
    }
}
