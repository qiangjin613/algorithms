package leetcode;

/**
 * <a href="https://leetcode.cn/problems/teemo-attacking/">495. 提莫攻击</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i > 0 && timeSeries[i] < duration + timeSeries[i - 1]) {
                sum += timeSeries[i] - timeSeries[i - 1];
            } else {
                sum += duration;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_495().findPoisonedDuration(new int[] {1, 4}, 2));
        System.out.println(new Solution_495().findPoisonedDuration(new int[] {1, 2}, 2));
        System.out.println(new Solution_495().findPoisonedDuration(new int[] {1, 2, 3, 4, 5}, 5));
    }
}
