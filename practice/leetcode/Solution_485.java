package leetcode;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones/">485. 最大连续 1 的个数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt ++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 0;
            }
        }
        return Math.max(maxCnt, cnt);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_485().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }
}
