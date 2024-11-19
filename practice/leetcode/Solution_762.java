package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/">762. 二进制表示中质数个计算置位</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_762 {

    /**
     * 对于输入端 left < right < 10^6 < 2^20，所以二进制中 1 的个数不会超过 19
     */
    public int countPrimeSetBits(int left, int right) {
        // 存储 19 内的素数
        boolean[] prime = new boolean[20];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i < 20; i++) {
            // 如果之前没处理过（不是素数）
            if (prime[i]) {
                // 处理 i 的倍数
                for (int j = i * 2; j < 20; j += i) {
                    prime[j] = false;
                }
            }
        }

        int ans = 0;
        while (left <= right) {
            int temp = left;
            int cnt = 0;
            while (temp != 0) {
                // 移除最左测的 1
                temp &= temp - 1;
                cnt ++;
            }
            if (prime[cnt]) {
                System.out.println(left);
                ans ++;
            }
            left ++;
        }
        return ans;
    }

    public int countPrimeSetBits2(int left, int right) {
        // 存储 19 内的素数
        int mask = 0B10100010100010101100;
        int ans = 0;
        for (int i = left; i <= right; i++) {
            // 构造掩码，然后与 mask 进行比较
            if ((1 << Integer.bitCount(i) & mask)!= 0) {
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_762().countPrimeSetBits2(6,10));
    }
}
