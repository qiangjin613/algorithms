package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/description/">680. 验证回文串 II</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_682 {

    public int calPoints(String[] operations) {
        List<Integer> datas = new LinkedList<>();
        for (String operation : operations) {
            switch (operation) {
                case "+":
                    datas.add(datas.get(datas.size() - 1) + datas.get(datas.size() - 2));
                    break;
                case "D":
                    datas.add(datas.get(datas.size() - 1) * 2);
                    break;
                case "C":
                    datas.remove(datas.size() - 1);
                    break;
                default:
                    datas.add(Integer.valueOf(operation));
            }
        }
        int score = 0;
        for (Integer data : datas) {
            score += data;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_682().calPoints(new String[] {"5","2","C","D","+"}));
    }
}
