package pta.basic;

import java.util.Scanner;

/**
 * 1051 复数乘法 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1051 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = in.nextDouble();
        }
        double resultA, resultB;
        resultA = nums[0] * nums[2] * Math.cos(nums[1] + nums[3]);
        resultB = nums[0] * nums[2] * Math.sin(nums[1] + nums[3]);
        System.out.printf("%.2f%+.2fi", dealNum(resultA), dealNum(resultB));
    }

    /**
     * 处理一种特殊情况: 将 (-0.005, 0) 之间的数变为 0.00 返回
     * System.out.printf("%.2f%+.2fi", -0.0005, -0.0005); // output: -0.00-0.00i
     * 这样是不合法的!!! 应该输出 0.00+0.00i
     * @param number 在 (-0.005, 0) 之间的数
     * @return 0.00 或 原数字
     */
    public static double dealNum(double number) {
        if (number < 0 && number > -0.005) {
            number = 0.00;
        }
        return number;
    }
}