import java.util.*;

/**
 * 素数（又称“质数”）
 * 一个大于 1 的自然数，除了 1 和它自身外，不能被其他自然数整除的数叫做素数（质数）。
 * 否则称为合数（规定 1 既不是质数也不是合数）。
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
class Prime {

    /**
     * 【判断 n 是不是素数】
     * 复杂度：O(sqrt(n))
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int sqr = (int) Math.sqrt(n * 1.0);
        for (int i = 2; i <= sqr; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int n) {
        if (n <= 1) {
            return false;
        }
        // 将 i 定义为 long 型，是为了放置 i^2 溢出
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 【打表法获取 maxn 以内的素数表（又称“埃氏筛法”）】
     * 从小到大枚举所有数，对每个素数，筛去它的所有倍数，剩下的就都是素数了（已知最小的素数是 2）
     * 复杂度：O(nloglogn)
     */
    public static List<Integer> findPrime(final int maxn) {
        // prime 存放所有素数
        List<Integer> prime = new ArrayList<>();
        // isPrime[i] 为 true，则 i 为素数
        boolean[] isPrime = new boolean[maxn + 1];
        // 默认都为素数
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= maxn; i++) {
            // 如果 i 是素数：
            if (isPrime[i]) {
                prime.add(i);
                // 筛去所有 i 的倍数：
                for (int j = i * 2; j < maxn; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return prime;
    }

    /**
     * 【质因子分解】
     * 每个合数都可以写成几个质数相乘的形式，分解质因数只针对合数。
     * 相关理论：
     * 1.如果一个正整数 n 存在 1 和本身之外的因子，那么一定是在 sqrt(n) 的左右成对出现
     * 强化结论：
     * 2.对一个正整数 n 来说，如果它存在 [2, n] 范围内的质因子，
     * 要么这些质因子全部小于等于 sqrt(n)，
     * 要么只存在一个大于 sqrt(n) 的质因子，而其余质因子全部小于等于 sqrt(n)。
     */
    class Factor {
        // x 为质因子，cnt 为其个数
        public int x, cnt;
        public Factor(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public void integerFactorization(int n) {
        System.out.print(n + " = ");
        List<Integer> primeList = findPrime(n);
        List<Factor> fac = new ArrayList<>();
        // 遍历 [1, sqrt(n)] 内所有质数
        for (Integer prime : primeList) {
            if (prime > Math.sqrt(n)) {
                break;
            }
            if (n % prime == 0) {
                int cnt = 0;
                while (n % prime == 0) {
                    cnt++;
                    n /= prime;
                }
                fac.add(new Factor(prime, cnt));
            }
        }
        // 如果有一个遍历 (sqrt(n)]
        if (n != 1) {
            fac.add(new Factor(n, 1));
        }
        // 打印质因子
        boolean flag = false;
        for (Factor factor : fac) {
            System.out.format("%s%d", flag ? "*" : "", factor.x);
            flag = true;
            if (factor.cnt > 1) {
                System.out.format("^%d", factor.cnt);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPrime(59));
        System.out.println(findPrime(997));
        new Prime().integerFactorization(1808);
    }
}
