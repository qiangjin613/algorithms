/**
 * 最大公约数
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
class GCD {

    /**
     * 辗转相除法
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(9, 3));
    }
}

/**
 * 最小公倍数
 */
class LCM {

    /**
     * 使用公式法求 a,b 最小公倍数
     */
    public static int lcm(int a, int b) {
        return a / GCD.gcd(a, b) * b;
    }
}
