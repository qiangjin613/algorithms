package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-watch/">401. 二进制手表</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_401 {

    /**
     * 方法一：枚举
     */
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            if (Integer.bitCount(h) > turnedOn) {
                continue;
            }
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return res;
    }

    /**
     * todo 方法二：回溯，类似于八皇后？
     */
    public List<String> readBinaryWatch2(int turnedOn) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_401().readBinaryWatch(1));
    }
}
