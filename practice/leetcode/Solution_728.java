package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/self-dividing-numbers/">728. 自除数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            int cur = i;
            while (cur != 0) {
                int temp = cur % 10;
                if (temp == 0 || i % temp != 0) {
                    flag = false;
                    break;
                }
                cur /= 10;
            }
            if (flag) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_728().selfDividingNumbers(1, 22));
        System.out.println(new Solution_728().selfDividingNumbers(47, 85));
    }
}
