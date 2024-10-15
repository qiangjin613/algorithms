package leetcode;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/">509. 斐波那契数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_509 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划 + 滚动数组
     * <p>
     * 时间复杂度：O(n)、空间复杂度：O(1)
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        int[] nums = new int[] {0, 0, 1};
        for (int i = 2; i <= n; i++) {
            nums[0] = nums[1];
            nums[1] = nums[2];
            nums[2] = nums[0] + nums[1];
        }
        return nums[2];
    }

    /**
     * 矩阵快速幂
     * <p>
     * 时间复杂度：O(log n)、空间复杂度：O(1)
     * <p>
     * <a href="https://leetcode.cn/problems/fibonacci-number/solutions/545049/fei-bo-na-qi-shu-by-leetcode-solution-o4ze/">力扣官方题解</a>
     */
    public int fib3(int n) {
        // 看不懂...
        return -1;
    }

    /**
     * 通项公式
     * <p>
     * 斐波那契数 F(n) 是齐次线性递推，根据递推方程 F(n)=F(n−1)+F(n−2)，可以写特征方程，然后得到通项公式，直接求解。
     * <p>
     * <a href="https://leetcode.cn/problems/fibonacci-number/solutions/545049/fei-bo-na-qi-shu-by-leetcode-solution-o4ze/">力扣官方题解</a>
     */
    public int fib4(int n) {
        // 忽略...
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_509().fib2(2));
        System.out.println(new Solution_509().fib2(3));
        System.out.println(new Solution_509().fib2(4));
    }
}
