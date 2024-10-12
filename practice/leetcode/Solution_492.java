package leetcode;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones/">485. 最大连续 1 的个数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_492 {

    public int[] constructRectangle(int area) {
        int w = 1, l = area;
        int abs = l - w;
        int resW = w, resL = l;
        while (w <= l) {
            if (w * l == area && l - w < abs) {
                resW = w;
                resL = l;
            }
            w++;
            l = area / w;
        }
        return new int[] {resL, resW};
    }

    /**
     * 针对上述逻辑的优化
     * <p>
     * <a href="https://leetcode.cn/problems/construct-the-rectangle/solutions/1060660/gou-zao-ju-xing-by-leetcode-solution-dest/">力扣官方题解：数学</a>
     */
    public int[] constructRectangle2(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[] {area / w, w};
    }

    public static void main(String[] args) {
        int[] ints = new Solution_492().constructRectangle(4);
        System.out.println(ints[0] + " " + ints[1]);

        int[] ints2 = new Solution_492().constructRectangle2(37);
        System.out.println(ints2[0] + " " + ints2[1]);
    }
}
