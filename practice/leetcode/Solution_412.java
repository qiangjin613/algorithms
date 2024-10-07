package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/fizz-buzz/">412. Fizz Buzz</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_412 {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n + 1);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_412().fizzBuzz(3));
    }
}
