package leetcode.week424;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-424/problems/zero-array-transformation-i/">Q2. 零数组变换 I</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_Q2 {

    /**
     * 超时，要优化，必须将重复 + 的逻辑优化调
     * <p>
     * 如何对多次累加进行优化？
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            for (int curIdx = i; curIdx <= j; curIdx++) {
                nums[curIdx]--;
            }
        }
        for (int datum : nums) {
            if (datum > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArray2(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] p = new int[n+1];
        for (int[] q : queries) {
            p[q[0]] ++;
            p[q[1]+1] --;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += p[i];
            if(sum < nums[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_Q2().isZeroArray2(new int[] {1,0,1}, new int[][]{{0,2}}));
    }
}
